package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Users;
import com.example.springmvc_demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
//import org.apache.commons.io.IOUtils;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserServiceImpl userService;
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        System.out.println(userName);
        System.out.println(userPassword);
        boolean userbool=false;
        request.getSession().setAttribute("userbool",userbool);
        if (userService.checkLoginUser(userName,userPassword) != null) {
            request.getSession().setAttribute("user", userService.checkLoginUser(userName,userPassword));
                int power=userService.checkPower(userName,userPassword);
                userbool=true;
                request.getSession().setAttribute("userbool",userbool);
                if(power==0) {
                    //管理员
                    return "forward:/jsp/in1.jsp";
                }
                else if (power==1){
                    //裁判
                    return "forward:/jsp/in1.jsp";
                }
                return "forward:/jsp/in1.jsp";
        } else {
            System.out.println("账号或者密码错误");
            model.addAttribute("msg", "账号或者密码错误");

            return "forward:/index.jsp";
        }
    }

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Users> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/registview")
    public String registview(Model model, HttpServletRequest request, HttpServletResponse response) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "hello,SpringMVC");
        System.out.println("registview");
        return "forward:/jsp/regist.jsp";
    }
    @RequestMapping("/regist")
    public String regist(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        System.out.println(username + " " + passwd );
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwd);

        int i = userService.addUser(user);
        if (i > 0){
            request.setAttribute("message","注册成功，请重新登录");
        }else {
            request.setAttribute("message","注册失败");
        }
        return "forward:/jsp/regist.jsp";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("uid");
        System.out.println(id);

        if (userService.deleteUser(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/users.jsp";
        }

    }

    @RequestMapping("/update")
    public String update(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("uid");
        String username = request.getParameter("userName");
        String passwd = request.getParameter("password");
        Users user = new Users();
        user.setUser_id(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(passwd);
        System.out.println(user);
        if (userService.updateUser(user)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("user", user);
            return "forward:/jsp/mine.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/mine.jsp";
        }
}

    @RequestMapping("/updateusers")
    public String updateusers(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("uid");
        String username = request.getParameter("userName");
        String passwd = request.getParameter("password");
        String power = request.getParameter("power");
        Users user = new Users();
        user.setUser_id(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(passwd);
        user.setPower(Integer.valueOf(power));
        System.out.println(user);
        if (userService.updateusers(user)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("user", user);
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/users.jsp";
        }
    }

    @RequestMapping("/toAddUser")
    public String toAddPaper() {
        return "forward:/jsp/addUser.jsp";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model, Users user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        int i = userService.addUser(user);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Users> userList = userService.getUserList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("userList", userList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/queryUser")
    public String queryUserLike(String queryName,Model model){
        System.out.println(queryName);
        List<Users> list = userService.queryUserLike(queryName);
        if (list.size() == 0) {
            list = userService.getUserList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("userList", list);
        return "forward:/jsp/users.jsp";
    }

    //安全退出，销毁服务器端的session

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();  //请求
        session.invalidate();        //销毁浏览器
    }



    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload")
    public String upload(MultipartFile image, HttpServletRequest request) throws IOException {
//获取原始文件名
        String originalFilename = image.getOriginalFilename();
// 获取上下文对象
        ServletContext servletContext = request.getServletContext();
// 获取当前的项目的实际目录
        String realPath = servletContext.getRealPath("/Upload");
        System.out.println("realPath：" + realPath);
        File uploaddir = new File(realPath);
        if (!uploaddir.exists()){
            uploaddir.mkdir();//如果目录不存在就创建这样一个目录
        }
        String filePath = realPath + "\\" + originalFilename;
        System.out.println(filePath);
//将文件存储在服务器的磁盘目录
        image.transferTo(new File(filePath));
        request.setAttribute("uploadMessage","上传成功");
        request.getSession().setAttribute("userimg","/Upload/" + originalFilename);
        request.getSession().setAttribute("userImgName", originalFilename);
        return "forward:/jsp/mine.jsp";
    }

//    @RequestMapping(value = "/download", method = RequestMethod.GET)
//    @ResponseBody
//    public void download(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        // 获取上下文对象
//        ServletContext servletContext = request.getServletContext();
//        // 获取当前的项目的实际目录
//        String realPath = servletContext.getRealPath("/");
//        System.out.println("realPath：" + realPath);
//        String fileName = (String) request.getSession().getAttribute("userImgName");
//        String filePath = realPath + "/Upload/" + fileName;
//        System.out.println(filePath);
//        File downloadfile = new File(filePath);
//
//        String mineType = servletContext.getMimeType(fileName);
//        System.out.println("mineType:" + mineType);
//
//        //1、设置response 响应头
//        response.reset(); //设置页面不缓存,清空buffer
//        response.setContentType(mineType);
//        //设置响应头
//        response.setHeader("Content-Disposition",
//                "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
//        try(
//                OutputStream stream = response.getOutputStream();
//                InputStream inputStream = new FileInputStream(downloadfile)
//        ){
//            IOUtils.copy(inputStream, stream);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }



}
