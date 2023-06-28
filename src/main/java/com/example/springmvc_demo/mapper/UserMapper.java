package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

//针对表【users(用户信息表)】的数据库操作Mapper
@Mapper
public interface UserMapper {
//得到要登录的用户
    @Select("select * from user where username = #{name} and password = #{password}")
    public Users checkLoginUser(@Param("name") String username, @Param("password") String password);

    @Select("select power from user where username = #{name} and password = #{password}")
    int checkPower(@Param("name") String username, @Param("password") String password);
    @Select("select id,username,password,name,email,power from user")
    List<Users> getUserList();

    @Insert("insert into user(username,password,name) values (#{username},#{password},#{name})")
    int addUser(Users user);

    @Delete("delete from user where id = #{id}")
    boolean deleteUser(int id);

    @Update("update user set username=#{username},password=#{password}, name=#{name},email=#{email} where id=#{id}")
    boolean updateUser(Users user);

    @Update("update user set username=#{username},password=#{password}, name=#{name},email=#{email},power=#{power} where id=#{id}")
    boolean updateusers(Users user);

    //根据id查询用户
    @Select("select * from user where id = #{id}")
    Users selectUserById(@Param("id") int id);

    //添加一个用户
    @Insert("insert into user(id,username,password,name,email,power) values (#{id},#{username},#{password},#{name},#{email},#{power})")
    int addUsers(Users user);

    //模糊查询,返回符合条件的User
    @Select("select * from user where username like concat('%','${value}','%')")
    List<Users> queryUserLike(@Param("value") String value);

}
