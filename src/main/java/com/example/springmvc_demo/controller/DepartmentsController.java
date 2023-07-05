package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Departments;
import com.example.springmvc_demo.service.DepartmentsServiceImpl;
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
@RequestMapping("/departments")
public class DepartmentsController {
    @Resource(name = "departmentsServiceImpl")
    private DepartmentsServiceImpl departmentsService;

    @RequestMapping("/departmentslist")
    public String departmentslist(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Departments> departmentslistList= departmentsService.getdepartmentsList();
        model.addAttribute("departmentslistList",departmentslistList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/departmentsdelete")
    public String departmentsdelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (departmentsService.deleteDepartments(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/users.jsp";
        }

    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("uid") String uid) {

        Departments departments = departmentsService.selectDepartmentsById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("departments",departments);
        System.out.println("modifyview");
        return "forward:/jsp/modifyuser.jsp";
    }

    @RequestMapping("/updatdepartments")
    public String updatdepartments(Model model, Departments departments,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
        if (departmentsService.updateDepartments(departments)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("departments", departments);
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/users.jsp";
        }
    }

    @RequestMapping("/toAdddepartments")
    public String toAddEvent() {
        return "forward:/jsp/addUser.jsp";
    }

    @RequestMapping("/adddepartments")
    public String adddepartments(Model model, Departments departments, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int i = departmentsService.addDepartments(departments);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Departments> departmentsList= departmentsService.getdepartmentsList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("departmentsList", departmentsList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/totalPoints")
    public String totalPoints(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<Departments> list =departmentsService.getdepartmentsList();
        for(int i=0;i<list.size();i++){
            int id = list.get(i).getDepartment_id();
            int totalPoints = departmentsService.totalPoints(id);
            list.get(i).setTeam_score(totalPoints);
        }
        List<Departments> list2 =departmentsService.getdepartmentsList();
        model.addAttribute("list2",list2);

        return "forward:/jsp/totalPoints.jsp";
    }


}
