package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Athletes;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AthleteMapper {
    //增删改查
    @Select("select * from athletes")
    List<Athletes> getAthleteList();
    @Insert("insert into athletes(athlete_id,athlete_name,gender,age,event_type,department_id) values (#{athlete_id},#{athlete_name},#{gender},#{age},#{event_type},#{department_id})")
    int addAthlete(Athletes athlete);
    @Delete("delete from athletes where athlete_id = #{athlete_id}")
    boolean deleteAthlete(int id);
    @Update("update athletes set athlete_name=#{athlete_name},gender=#{gender},age=#{age},event_type=#{event_type},department_id=#{department_id} where athlete_id=#{athlete_id}")
    boolean updateAthlete(Athletes athlete);
    //模糊查询,返回符合条件的User
    @Select("select * from athletes where athlete_name like concat('%','${value}','%')")
    List<Athletes> queryAthletesLike(@Param("value") String value);
    @Select("select * from athletes where athlete_id = #{athlete_id}")
    Athletes selectAthleteById(@Param("athlete_id") int id);

    @Update("update athletes set athlete_name=#{athlete_name}, gender=#{gender}, age=#{age},  event_type=#{event_type},department_id=#{department_id} where athlete_id=#{athlete_id}")
    int updateAthleteById(Athletes athlete);
}
