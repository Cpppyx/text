package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.service.DormitoryServiceImpl;
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
@RequestMapping("/dormitory")
public class DormitoryController {
    @Resource(name = "dormitoryServiceImpl")
    private DormitoryServiceImpl dormitoryService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Dormitory> List = dormitoryService.getList();
        model.addAttribute("List", List);
        return "forward:/jsp/dormitory.jsp";
    }

    @RequestMapping("/toAdd")
    public String toAddPaper() {
        return "forward:/jsp/addDorinfo.jsp";
    }

    @RequestMapping("/add")
    public String addUser(Model model, Dormitory dormitory, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        String id = request.getParameter("id");
//        String roomid = request.getParameter("roomid");
//        String dormitoryname = request.getParameter("dormitoryname");
//        Dormitoryinfo dormitoryinfo1 = new Dormitoryinfo();
//        dormitoryinfo1.setId(Integer.parseInt(id));
//        dormitoryinfo1.setRoomid(roomid);
//        dormitoryinfo1.setDormitoryname(dormitoryname);
        int i = dormitoryService.add(dormitory);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Dormitory> List = dormitoryService.getList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("List", List);
        return "forward:/jsp/dormitory.jsp";
    }

    @RequestMapping("/query")
    public String queryLike(String queryName,Model model){
        System.out.println(queryName);
        List<Dormitory> list = dormitoryService.queryLike(queryName);
        if (list.size() == 0) {
            list = dormitoryService.getList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("List", list);
        return "forward:/jsp/dormitory.jsp";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (dormitoryService.delete(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");

        }else {
            request.setAttribute("message","删除失败");

        }
        return "forward:/jsp/dormitory.jsp";
    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("id") String uid) {
        Dormitory dormitory = dormitoryService.selectById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("dormitory", dormitory);
        System.out.println("modifyview");
        return "forward:/jsp/modifydormitory.jsp";
    }

    @RequestMapping("/update")
    public String updateusers(Model model, Dormitory dormitory, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(dormitory);
        if (dormitoryService.update(dormitory)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("dormitory", dormitory);

        }else {
            request.setAttribute("message","修改失败");

        }
        return "forward:/jsp/dormitory.jsp";
    }
}
