package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.AthleteMapper;
import com.example.springmvc_demo.pojo.Athletes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService{
    @Resource
    AthleteMapper athleteMapper;
    @Override
    public List<Athletes> getAthleteList() {
        return athleteMapper.getAthleteList();
    }

    @Override
    public int addAthlete(Athletes athlete) {
        return athleteMapper.addAthlete(athlete);
    }

    @Override
    public boolean deleteAthlete(int id) {
        return athleteMapper.deleteAthlete(id);
    }

    @Override
    public int updateAthleteById(Athletes athlete) {
        return athleteMapper.updateAthleteById(athlete);
    }


    @Override
    public boolean updateAthlete(Athletes athlete) {
        return athleteMapper.updateAthlete(athlete);
    }

    @Override
    public List<Athletes> queryAthletesLike(String value) {
        return athleteMapper.queryAthletesLike(value);
    }

    @Override
    public Athletes selectAthleteById(int id) {
        return athleteMapper.selectAthleteById(id);
    }
}
