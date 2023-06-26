package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Dormrepair;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormrepairMapper {
    @Select("select * from dormrepair where roomid=\n" +
            "                                  (select roomid from dormitoryinfo where userid=(\n" +
            "                                      select user.username from user where user.username=#{username}\n" +
            "                                  ))\n" +
            "                              and dormitoryname=(select dormitoryname from dormitoryinfo where userid=(\n" +
            "        select user.username from user where user.username=#{username}\n" +
            "    ))")
    List<Dormrepair> getList(@Param("username") String username);

    //模糊查询,返回符合条件的User
    @Select("select * from dormrepair where repairreason like concat('%','${value}','%')")
//    @Select("select * from dormrepair where repairreason like ('%${value}%');")
    List<Dormrepair> queryLike(@Param("value") String value);

    @Insert("insert into dormrepair(id,roomid,dormitoryname,username,repairtime,repairreason,repairstatus) values (#{id},#{roomid},#{dormitoryname},#{username},#{repairtime},#{repairreason},#{repairstatus})")
    int add(Dormrepair dormrepair);

    @Delete("delete from dormrepair where id = #{id}")
    boolean delete(int id);

    @Update("update dormrepair set roomid=#{roomid}, dormitoryname=#{dormitoryname},username=#{username},repairtime=#{repairtime},repairreason=#{repairreason},repairstatus=#{repairstatus} where id=#{id}")
    boolean update(Dormrepair dormrepair);

    @Select("select * from dormrepair where id = #{id}")
    Dormrepair selectById(@Param("id") int id);

    @Select("select * from dormrepair")
    List<Dormrepair> getList1();
}
