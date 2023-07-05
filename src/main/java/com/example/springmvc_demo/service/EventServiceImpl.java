package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.EventMapper;
import com.example.springmvc_demo.pojo.Events;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EventServiceImpl implements EventService{
    @Resource
    EventMapper eventMapper;
    @Override
    public List<Events> getEventList() {
        return eventMapper.getEventList();
    }

    @Override
    public int addEvent(Events event) {
        return eventMapper.addEvent(event);
    }

    @Override
    public boolean deleteEvent(int id) {
        return eventMapper.deleteEvent(id);
    }

    @Override
    public boolean updateEvent(Events event) {
        return eventMapper.updateEvent(event);
    }

    @Override
    public List<Events> queryEventLike(String value) {
        return eventMapper.queryEventsLike(value);
    }

    @Override
    public Events selectEventById(int id) {
        return eventMapper.selectEventById(id);
    }

    @Override
    public List<Events> getEventIdList() {
        return eventMapper.getEventIdList();
    }
}
