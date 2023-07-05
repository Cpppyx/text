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
        System.out.println(athletesList);
        model.addAttribute("athletesList", athletesList);
        return "forward:/jsp/Athletes.jsp";
    }

    @RequestMapping("/athletedelete")
    public String athletedelete(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("athlete_id");
        System.out.println(id);

        if (athleteService.deleteAthlete(Integer.parseInt(id))){
            request.setAttribute("message","删除成功");
            return "forward:/jsp/Athletes.jsp";
        }else {
            request.setAttribute("message","删除失败");
            return "forward:/jsp/Athletes.jsp";
        }

    }


    @RequestMapping("/toUpdateAthlete")
    public String toUpdateAthlete(Model model, @RequestParam("athlete_id") String athlete_id) {
        Athletes athlete = athleteService.selectAthleteById(Integer.parseInt(athlete_id));
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("athlete", athlete);
        System.out.println("toUpdateAthlete");
        return "forward:/jsp/modifyAthlete.jsp";
    }


    @RequestMapping("/updatAthlete")
    public String updatAthlete(Model model, Athletes athletes, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
        if (athleteService.updateAthlete(athletes)){
            request.setAttribute("message","修改成功");
            request.getSession().setAttribute("athlete",athletes);
            return "forward:/jsp/Athletes.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "forward:/jsp/Athletes.jsp";
        }
    }
    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, Athletes athlete) {
        System.out.println(athlete);
        int i = athleteService.updateAthleteById(athlete);
        if (i > 0){
            request.setAttribute("message","修改成功");
            List<Athletes> athletesList = athleteService.getAthleteList();
            request.setAttribute("list", athletesList);
        }else {
            request.setAttribute("msg","修改失败");
        }
        return "forward:/jsp/Athletes.jsp";
    }

    @RequestMapping("/toAddAthlete")
    public String toAddAthlete() {
        return "forward:/jsp/addAthlete.jsp";
    }

    @RequestMapping("/addAthlete")
    public String addAthlete(Model model, Athletes athletes, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int i = athleteService.addAthlete(athletes);
        if (i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

        List<Athletes> athletesList= athleteService.getAthleteList();
        //向模型中添加属性userList与值，可以在JSP页面中取出并渲染
        model.addAttribute("athletelist",athletesList);
        return "forward:/jsp/Athletes.jsp";
    }

    @RequestMapping("/queryAthlete")
    public String queryAthleteLike(String queryName,Model model){
        System.out.println(queryName);
        List<Athletes> list= athleteService.queryAthletesLike(queryName);
        if (list.size() == 0) {
            list = athleteService.getAthleteList();
            model.addAttribute("error","未查到");
        }
        System.out.println(list);
        model.addAttribute("athletesList", list);
        return "forward:/jsp/Athletes.jsp";
    }





}
