package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Events;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {
    //增删改查
    @Select("select * from events")
    List<Events> getEventList();
    @Insert("insert into events(event_id,event_name,event_type,event_location,event_date) values (#{id},#{name},#{time},#{type},#{location},#{date})")
    int addEvent(Events event);
    @Delete("delete from events where event_id = #{id}")
    boolean deleteEvent(int id);
    @Update("update events set event_name=#{name},event_type=#{type},event_location=#{location},event_date=#{date} where event_id=#{id}")
    boolean updateEvent(Events event);
    //模糊查询,返回符合条件的User
    @Select("select * from events where event_name like concat('%','${value}','%')")
    List<Events> queryEventsLike(@Param("value") String value);
    @Select("select * from events where event_id = #{id}")
    Events selectEventById(@Param("id") int id);

    @Select("select event_id from events")
    List<Events> getEventIdList();

}
