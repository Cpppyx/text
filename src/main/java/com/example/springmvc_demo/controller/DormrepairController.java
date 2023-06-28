package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.service.DormrepairSerciceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/dormrepair")
public class DormrepairController {
    int i=0;
    String username1;
    @Resource(name = "dormrepairSerciceImpl")
    private DormrepairSerciceImpl dormrepairSercice;

    @RequestMapping("/list")
    public String list(Model model,@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
       username1=username;
        response.setCharacterEncoding("UTF-8");
        List<Dormrepair> List = dormrepairSercice.getList(username);
        List<Dormrepair> List1 = dormrepairSercice.getList1();
        i=List1.size();
        model.addAttribute("List", List);
        return "forward:/jsp/dormrepair.jsp";
    }

    @RequestMapping("/toAdd")
    public String toAddPaper() {
        return "forward:/jsp/addDorPair.jsp";
    }

    @RequestMapping("/add")
    public String addUser(Model model,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String roomid = request.getParameter("roomid");
        String dormitoryname = request.getParameter("dormitoryname");
        String username = request.getParameter("username");
        String repairreason = request.getParameter("repairreason");
        Dormrepair dormrepair = new Dormrepair();
        dormrepair.setId(++i);
        dormrepair.setRoomid(roomid);
        dormrepair.setDormitoryname(dormitoryname);
        dormrepair.setUsername(username);
        dormrepair.setRepairtime(DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE).format(new java.util.Date()));
        dormrepair.setRepairreason(repairreason);
        dormrepair.setRepairstatus("未处理");
        System.out.println(dormrepair);


        int i = dormrepairSercice.add(dormrepair);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Dormrepair> List = dormrepairSercice.getList(username1);
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("List", List);
        return "forward:/jsp/dormrepair.jsp";
    }

    @RequestMapping("/query")
    public String queryLike(String queryName,Model model){
        System.out.println(queryName);
        List<Dormrepair> list =dormrepairSercice.queryLike(queryName);
        if (list.size() == 0) {
            list =dormrepairSercice.getList(username1);
            model.addAttribute("error","未查到");
        }
        model.addAttribute("List", list);
        return "forward:/jsp/dormrepair.jsp";
    }

    @RequestMapping("/list1")
    public String list1(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        List<Dormrepair> List = dormrepairSercice.getList1();
        i=List.size();
        model.addAttribute("List", List);
        return "forward:/jsp/dormrepair3.jsp";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (dormrepairSercice.delete(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");

        }else {
            request.setAttribute("message","删除失败");

        }
        return "forward:/jsp/dormrepair3.jsp";
    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("id") String uid) {
        Dormrepair dormrepair = dormrepairSercice.selectById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("dormrepair", dormrepair);
        System.out.println("modifyview");
        return "forward:/jsp/modifyDorPair.jsp";
    }

    @RequestMapping("/update")
    public String updateusers(Model model, Dormrepair dormrepair, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(dormrepair);
        if (dormrepairSercice.update(dormrepair)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("dormrepair", dormrepair);

        }else {
            request.setAttribute("message","修改失败");

        }
        return "forward:/jsp/dormrepair3.jsp";
    }
}
