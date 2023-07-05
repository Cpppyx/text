package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Athletes;

import java.util.List;

public interface AthleteService {
    public List<Athletes> getAthleteList();
    public int addAthlete(Athletes athlete);
    public boolean deleteAthlete(int id);
    public int updateAthleteById(Athletes athlete);
    public boolean updateAthlete(Athletes athlete);

    public List<Athletes> queryAthletesLike(String value);
    public Athletes selectAthleteById(int id);
}
