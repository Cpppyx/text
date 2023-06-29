package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Events;
import com.example.springmvc_demo.service.EventServiceImpl;
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
@RequestMapping("/event")
public class EventController {
    @Resource(name = "eventServiceImpl")
    private EventServiceImpl eventService;

    @RequestMapping("/eventlist")
    public String eventlist(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Events> eventsList= eventService.getEventList();
        model.addAttribute("eventlist",eventsList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/eventdelete")
    public String eventdelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);

        if (eventService.deleteEvent(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/users.jsp";
        }

    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("uid") String uid) {
        Events event = eventService.selectEventById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("event", event);
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
