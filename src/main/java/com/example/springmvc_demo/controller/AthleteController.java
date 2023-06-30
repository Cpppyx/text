package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Athletes;
import com.example.springmvc_demo.service.AthleteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/athlete")
public class AthleteController {
    @Resource(name = "athleteServiceImpl")
    private AthleteServiceImpl athleteService;
    @RequestMapping("/athletelist")
    public String athletelist(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Athletes> athletesList= athleteService.getAthleteList();
        model.addAttribute("athletelist",athletesList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/athletedelete")
    public String athletedelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (athleteService.deleteAthlete(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/users.jsp";
        }

    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("uid") String uid) {
        Athletes athlete = athleteService.selectAthleteById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("athlete", athlete);
        System.out.println("modifyview");
        return "forward:/jsp/modifyuser.jsp";
    }

//    @RequestMapping("/updateusers")
//    public String updateusers(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String id = request.getParameter("uid");
//        String username = request.getParameter("userName");
//        String passwd = request.getParameter("password");
//        String power = request.getParameter("power");
//        Users user = new Users();
//        user.setUser_id(Integer.valueOf(id));
//        user.setUsername(username);
//        user.setPassword(passwd);
//        user.setPower(Integer.valueOf(power));
//        System.out.println(user);
//        if (userService.updateusers(user)){
//            request.setAttribute("message","修改成功");
//            request.getSession().setAttribute("user", user);
//            return "forward:/jsp/users.jsp";
//        }else {
//            request.setAttribute("message","修改失败");
//            return "forward:/jsp/users.jsp";
//        }
//    }
}