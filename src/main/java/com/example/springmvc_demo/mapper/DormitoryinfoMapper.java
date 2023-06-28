package com.example.springmvc_demo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormitoryinfoMapper {
    @Select("select * from dormitoryinfo")
    List<Dormitoryinfo> getList();

    @Insert("insert into dormitoryinfo(id,roomid,dormitoryname,bedid,username,userid) values (#{id},#{roomid},#{dormitoryname},#{bedid},#{username},#{userid})")
    int add(Dormitoryinfo dormitoryinfo);

    //模糊查询,返回符合条件的User
    @Select("select * from dormitoryinfo where dormitoryname like concat('%','${value}','%')")
    List<Dormitoryinfo> queryLike(@Param("value") String value);

    @Delete("delete from dormitoryinfo where id = #{id}")
    boolean delete(int id);

    @Select("select * from dormitoryinfo where id = #{id}")
    Dormitoryinfo selectById(@Param("id") int id);

    @Update("update dormitoryinfo set roomid=#{roomid}, dormitoryname=#{dormitoryname},bedid=#{bedid},username=#{username},userid=#{userid} where id=#{id}")
    boolean updat(Dormitoryinfo dormitoryinfo);

    @Select("select * from dormitoryinfo where roomid=(select roomid from dormitoryinfo where userid=(select user.username from user where user.username=#{username}))  and dormitoryname=(select dormitoryname from dormitoryinfo where userid=(select user.username from user where user.username=#{username}));")
    List<Dormitoryinfo> getList1(@Param("username") String username);

    @Select("select * from dormitoryinfo where userid in\n" +
            "(select studentid from student where classid =\n" +
            "(select id from class where counsellor=\n" +
            "                            (\n" +
            "                                select name from user where username=#{username}\n" +
            "                                )));")
    List<Dormitoryinfo> getList2(@Param("username") String username);

    @Select("select * from (select * from dormitoryinfo where userid in\n" +
            "(select studentid from student where classid =\n" +
            "(select id from class where counsellor=\n" +
            "                            (\n" +
            "                                select name from user where username=#{username}\n" +
            "                                )))) whereuserid like concat('%','${value}','%')")
    List<Dormitoryinfo> queryLike2(@Param("username") String username,@Param("value") String value);
}
