package com.example.springmvc_demo.controller;

import com.example.springmvc_demo.pojo.Athlete_event;
import com.example.springmvc_demo.pojo.Events;
import com.example.springmvc_demo.service.Athlete_eventServiceImpl;
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
@RequestMapping("/athlete_event")
public class Athlete_eventController {
    @Resource(name = "athlete_eventServiceImpl")
    private Athlete_eventServiceImpl athlete_eventService;

    @Resource(name = "eventServiceImpl")
    private EventServiceImpl eventService;

    @RequestMapping("/Athlete_eventlist")
    public String athlete_eventlist(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Athlete_event> athlete_eventList= athlete_eventService.getAthlete_eventList();
        model.addAttribute("athlete_eventlist",athlete_eventList);

        return "forward:/jsp/Athlete_event.jsp";
    }


    @RequestMapping("/athlete_eventdelete")
    public String athlete_eventdelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("athlete_id");
        System.out.println(id);

        if (athlete_eventService.deleteAthlete_event(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/Athlete_event.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/Athlete_event.jsp";
        }

    }

    @RequestMapping("/modifyview")
    public String modifyview(Model model, @RequestParam("uid") String uid) {
        Athlete_event athlete_event = athlete_eventService.selectAthlete_eventById(Integer.parseInt(uid));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("athlete_event", athlete_event);
        System.out.println("modifyview");
        return "forward:/jsp/modifyAthlete_event.jsp";
    }

    @RequestMapping("/updateAthlete_event")
    public String updateAthlete_event(Model model, Athlete_event athlete_event, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
        if (athlete_eventService.updateAthlete_event(athlete_event)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("athlete_event",athlete_event);
            return "forward:/jsp/Athlete_event.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/Athlete_event.jsp";
        }
    }

    @RequestMapping("/toAddAthlete_event")
    public String toAddAthlete_event() {
        return "forward:/jsp/addAthlete_event.jsp";
    }

    @RequestMapping("/addAthlete_event")
    public String addAthlete_event(Model model, Athlete_event athlete_event, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int i =athlete_eventService.addAthlete_event(athlete_event);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        List<Athlete_event> athlete_eventList= athlete_eventService.getAthlete_eventList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("athlete_eventlist",athlete_eventList);
        return "forward:/jsp/Athlete_event.jsp";
    }

    @RequestMapping("/queryAthlete_event")
    public String queryAthlete_eventLike(String queryName,Model model){
        System.out.println(queryName);

        List<Athlete_event> list= athlete_eventService.queryAthlete_eventLike(queryName);
        if (list.size() == 0) {
            list = athlete_eventService.getAthlete_eventList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list", list);
        return "forward:/jsp/Athlete_event.jsp";
    }
    @RequestMapping("/toUpdateAthlete_event")
    public String toUpdateAthlete(Model model, @RequestParam("athlete_id") String athlete_id) {
        Athlete_event athlete_event = athlete_eventService.selectAthlete_eventById(Integer.parseInt(athlete_id));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("athlete_event", athlete_event);
        System.out.println("toUpdateAthlete_event");
        return "forward:/jsp/modifyAthlete_event.jsp";
    }
    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, Athlete_event athlete_event) {
        System.out.println(athlete_event);
        int i = athlete_eventService.updateAthlete_eventById(athlete_event);
        if (i > 0){
            request.setAttribute("message","修改成功");
            List<Athlete_event> athlete_eventlist = athlete_eventService.getAthlete_eventList();
            request.setAttribute("list", athlete_eventlist);
        }else {
            request.setAttribute("msg","修改失败");
        }
        return "forward:/jsp/Athlete_event.jsp";
    }

    @RequestMapping("/getWinnerList")
    public String getWinnerList(Model model){
        List<Athlete_event> list= athlete_eventService.getWinnerList();
        for(int i=0;i<list.size();i++) {
            if (i % 5 == 0) {
                list.get(i).setEndowment_score(7);
            } else if (i % 5 == 1) {
                list.get(i).setEndowment_score(5);
            } else if (i % 5 == 2) {
                list.get(i).setEndowment_score(3);
            } else if (i % 5 == 3) {
                list.get(i).setEndowment_score(2);
            } else if (i % 5 == 4) {
                list.get(i).setEndowment_score(1);
            }
        }
        List<Athlete_event> list1= athlete_eventService.getAthlete_eventList();
        model.addAttribute("list1",list1);
        return "forward:/jsp/winner.jsp";
    }

    @RequestMapping("/setRank")
    public String setRank(Model model){
      List<Events> list= eventService.getEventIdList();
        for(int i=0;i<list.size();i++) {
            List<Athlete_event> list1= athlete_eventService.tosetRank(list.get(i).getEvent_id());
            for(int j=0;j<list1.size();j++) {
               list1.get(j).setRanking("第"+j+1+"名");
            }
        }
        return "forward:/jsp/winner.jsp";
    }


}
