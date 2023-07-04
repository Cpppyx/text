package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.Athlete_eventMapper;
import com.example.springmvc_demo.pojo.Athlete_event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Athlete_eventServiceImpl implements Athlete_eventService{
    @Resource
    Athlete_eventMapper athlete_eventMapper;
    @Override
    public List<Athlete_event> getAthlete_eventList() {
        return athlete_eventMapper.getAthlete_eventList();
    }

    @Override
    public int addAthlete_event(Athlete_event athlete_event) {
        return athlete_eventMapper.addAthlete_event(athlete_event);
    }

    @Override
    public boolean deleteAthlete_event(int id) {
        return athlete_eventMapper.deleteAthlete_event(id);
    }

    @Override
    public boolean updateAthlete_event(Athlete_event athlete_event) {
        return athlete_eventMapper.updateAthlete_event(athlete_event);
    }

    @Override
    public List<Athlete_event> queryAthlete_eventLike(String value) {
        return athlete_eventMapper.queryAthlete_eventLike(value);
    }

    @Override
    public Athlete_event selectAthlete_eventById(int id) {
        return athlete_eventMapper.selectAthlete_eventById(id);
    }

    @Override
    public List<Athlete_event> getWinnerList() {
        return athlete_eventMapper.getWinnerList();
    }

    @Override
    public List<Athlete_event> tosetRank(int id) {
        return athlete_eventMapper.tosetRank(id);
    }
}
