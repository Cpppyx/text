package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Athlete_event;

import java.util.List;

public interface Athlete_eventService {
    public List<Athlete_event> getAthlete_eventList();
    public int addAthlete_event(Athlete_event athlete_event);
    public boolean deleteAthlete_event(int id);
    public boolean updateAthlete_event(Athlete_event athlete_event);
    public List<Athlete_event> queryAthlete_eventLike(String value);
    public Athlete_event selectAthlete_eventById(int id);

    public int updateAthlete_eventById(Athlete_event athlete_event);
    List<Athlete_event> getWinnerList();
    List<Athlete_event> tosetRank(int id);
}
