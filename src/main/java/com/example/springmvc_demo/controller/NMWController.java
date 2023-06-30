package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.NMW;
import com.example.springmvc_demo.service.NMVServiceImpl;
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
@RequestMapping("/NMW")
public class NMWController {
    @Resource(name = "NMVServiceImpl")
    private NMVServiceImpl nmvService;

    @RequestMapping("/nmvlist")
    public String nmvlist(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<NMW> nmvList= nmvService.getnmvList();
        model.addAttribute("nmvList",nmvList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/nmvdelete")
    public String eventdelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (nmvService.deleteNMV(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/users.jsp";
        }

    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("uid") String uid) {
        NMW nmw = nmvService.selectNmvById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("nmw",nmw);
        System.out.println("modifyview");
        return "forward:/jsp/modifyuser.jsp";
    }

    @RequestMapping("/updatnmv")
    public String updatevent(Model model, NMW nmw,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String id = request.getParameter("uid");
//        String name = request.getParameter("userName");
//        String type = request.getParameter("password");
//        String location = request.getParameter("power");
//
//        Events event = new Events();
//        event.setEvent_id(Integer.valueOf(id));
//        event.setEvent_name(username);
//        event.setEvent_date();
//
//        System.out.println(event);
        if (nmvService.updatenmv(nmw)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("nmw", nmw);
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/users.jsp";
        }
    }

    @RequestMapping("/toAddNmv")
    public String toAddEvent() {
        return "forward:/jsp/addUser.jsp";
    }

    @RequestMapping("/addNmv")
    public String addEvent(Model model, NMW nmw, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int i = nmvService.addnmv(nmw);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<NMW> nmwList= nmvService.getnmvList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("nmwList", nmwList);
        return "forward:/jsp/users.jsp";
    }



}
