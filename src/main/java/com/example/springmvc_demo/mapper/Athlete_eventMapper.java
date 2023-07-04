package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Athlete_event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Athlete_eventMapper {
    //增删改查
    @Select("select * from Athlete_event")
    List<Athlete_event> getAthlete_eventList();
    @Insert("insert into Athlete_event(athlete_id,event_id,score,endowent_score,ranking) values (#{athlete_id},#{event_id},#{score},#{endowent_score},#{ranking}")
    int addAthlete_event(Athlete_event athlete_event);
    @Delete("delete from addAthlete_event where athlete_id = #{athlete_id }")
    boolean deleteAthlete_event(int id);
    @Update("update Athlete_event set event_id=#{event_id},score=#{score},endowent_score=#{endowent_score},ranking=#{ranking} where athlete_id=#{athlete_id}")
    boolean updateAthlete_event(Athlete_event athlete_event);
    //模糊查询,返回符合条件的User
    @Select("select * from Athlete_event where event_id like concat('%','${value}','%')")
    List<Athlete_event> queryAthlete_eventLike(@Param("value") String value);
    @Select("select * from Athlete_event where athlete_id = #{athlete_id}")
    Athlete_event selectAthlete_eventById(@Param("athlete_id") int id);

    @Select("select * from athlete_event a\n" +
            "where 5 > (select count(*) from athlete_event b\n" +
            "           where b.event_id = a.event_id\n" +
            "             and b.score > a.score\n" +
            ") order by a.event_id ,a.score desc")
    List<Athlete_event> getWinnerList();

    @Select("select * from athlete_event  where event_id= #{id} order by score desc")
    List<Athlete_event> tosetRank(@Param("id") int id);



}
