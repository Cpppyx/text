package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Events;

import java.util.List;

public interface EventService {
    public List<Events> getEventList();
    public int addEvent(Events event);
    public boolean deleteEvent(int id);
    public boolean updateEvent(Events event);
    public List<Events> queryEventLike(String value);
    public Events selectEventById(int id);

    List<Events> getEventIdList();
}
