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

    @RequestMapping("/updatevent")
    public String updatevent(Model model, Events events,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
        if (eventService.updateEvent(events)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("event", events);
            return "forward:/jsp/users.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/users.jsp";
        }
    }

    @RequestMapping("/toAddEvent")
    public String toAddEvent() {
        return "forward:/jsp/addUser.jsp";
    }

    @RequestMapping("/addEvent")
    public String addEvent(Model model, Events events, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int i = eventService.addEvent(events);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Events> eventsList= eventService.getEventList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("eventList", eventsList);
        return "forward:/jsp/users.jsp";
    }

    @RequestMapping("/queryEventLike")
    public String queryEventLike(String queryName,Model model){
        System.out.println(queryName);
        List<Events> list= eventService.queryEventLike(queryName);
        if (list.size() == 0) {
            list = eventService.getEventList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("userList", list);
        return "forward:/jsp/users.jsp";
    }




}
