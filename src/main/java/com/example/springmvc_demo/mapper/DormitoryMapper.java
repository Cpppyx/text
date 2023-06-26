package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Dormitory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormitoryMapper {
    @Select("select * from dormitory")
    List<Dormitory> getList();

    @Insert("insert into dormitory(id,roomid,dormitoryname) values (#{id},#{roomid},#{dormitoryname})")
    int add(Dormitory dormitory);

    //模糊查询,返回符合条件的User
    @Select("select * from dormitory where dormitoryname like concat('%','${value}','%')")
    List<Dormitory> queryLike(@Param("value") String value);

    @Delete("delete from dormitory where id = #{id}")
    boolean delete(int id);

    @Select("select * from dormitory where id = #{id}")
    Dormitory selectById(@Param("id") int id);

    @Update("update dormitory set roomid=#{roomid}, dormitoryname=#{dormitoryname} where id=#{id}")
    boolean update(Dormitory dormitory);



}
