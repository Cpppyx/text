package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Dormitoryinfo;
import com.example.springmvc_demo.service.DormitoryinfoServiceImpl;
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
@RequestMapping("/dormitoryinfo")
public class DormitoryinfoController {
    @Resource(name = "dormitoryinfoServiceImpl")
    private DormitoryinfoServiceImpl dormitoryinfoService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Dormitoryinfo> List = dormitoryinfoService.getList();
        model.addAttribute("List", List);
        return "forward:/jsp/ssrl.jsp";
    }

    @RequestMapping("/toAdd")
    public String toAddPaper() {
        return "forward:/jsp/addDormitory.jsp";
    }

    @RequestMapping("/add")
    public String addUser(Model model, Dormitoryinfo dormitoryinfo, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int i = dormitoryinfoService.add(dormitoryinfo);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Dormitoryinfo> List = dormitoryinfoService.getList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("List", List);
        return "forward:/jsp/ssrl.jsp";
    }

    @RequestMapping("/query")
    public String queryLike(String queryName,Model model){
        System.out.println(queryName);
        List<Dormitoryinfo> list = dormitoryinfoService.queryLike(queryName);
        if (list.size() == 0) {
            list = dormitoryinfoService.getList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("List", list);
        return "forward:/jsp/ssrl.jsp";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (dormitoryinfoService.delete(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");

        }else {
            request.setAttribute("message","删除失败");

        }
        return "forward:/jsp/ssrl.jsp";
    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("id") String uid) {
        Dormitoryinfo dormitoryinfo = dormitoryinfoService.selectById(Integer.parseInt(uid));
        System.out.println(dormitoryinfo);
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("dormitoryinfo", dormitoryinfo);
        System.out.println("modifyview");
        return "forward:/jsp/modifydorinfo.jsp";
    }

    @RequestMapping("/update")
    public String updateusers(Model model,Dormitoryinfo dormitoryinfo,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");


        if (dormitoryinfoService.updat(dormitoryinfo)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("dormitoryinfo", dormitoryinfo);

        }else {
            request.setAttribute("message","修改失败");

        }
        return "forward:/jsp/ssrl.jsp";
    }

    @RequestMapping("/list1")
    public String list1(Model model, @RequestParam("username") String username,HttpServletRequest request, HttpServletResponse response) {

        List<Dormitoryinfo> List = dormitoryinfoService.getList1(username);
        model.addAttribute("List", List);
        System.out.println(List);
        return "forward:/jsp/studentssrl.jsp";
    }
String username2;
    @RequestMapping("/list2")
    public String list2(Model model, @RequestParam("username") String username,HttpServletRequest request, HttpServletResponse response) {
        username2=username;
        List<Dormitoryinfo> List2 = dormitoryinfoService.getList2(username);
        model.addAttribute("List2", List2);
        return "forward:/jsp/ssrl2.jsp";
    }

//    @RequestMapping("/query2")
//    public String queryLike2(String queryName,Model model,HttpServletRequest request, HttpServletResponse response){
//
//        System.out.println(queryName);
//        System.out.println(username2);
//        List<Dormitoryinfo> list2 = dormitoryinfoService.queryLike2(username2,queryName);
//        if (list2.size() == 0) {
//            list2 = dormitoryinfoService.getList2(username2);
//            model.addAttribute("error","未查到");
//        }
//        model.addAttribute("List2", list2);
//        return "forward:/jsp/ssrl2.jsp";
//    }

    @RequestMapping("/list3")
    public String list3(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Dormitoryinfo> List = dormitoryinfoService.getList();
        model.addAttribute("List", List);
        return "forward:/jsp/ssrl3.jsp";
    }
}
