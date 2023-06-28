package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

//针对表【users(用户信息表)】的数据库操作Mapper
@Mapper
public interface UserMapper {
//得到要登录的用户
    @Select("select * from users where username = #{name} and password = #{password}")
    public Users checkLoginUser(@Param("name") String username, @Param("password") String password);

    @Select("select power from users where username = #{name} and password = #{password}")
    int checkPower(@Param("name") String username, @Param("password") String password);
    @Select("select user_id,role,username,password,power from users")
    List<Users> getUserList();

    @Insert("insert into users(username,password) values (#{username},#{password})")
    int addUser(Users user);

    @Delete("delete from users where user_id = #{id}")
    boolean deleteUser(int id);

    @Update("update users set username=#{username},password=#{password} where user_id=#{id}")
    boolean updateUser(Users user);

    @Update("update users set username=#{username},password=#{password},power=#{power} where user_id=#{id}")
    boolean updateusers(Users user);

    //根据id查询用户
    @Select("select * from users where user_id = #{id}")
    Users selectUserById(@Param("id") int id);

    //添加一个用户
    @Insert("insert into users(user_id,role,username,password,power) values (#{id},#{username},#{password},#{power})")
    int addUsers(Users user);

    //模糊查询,返回符合条件的User
    @Select("select * from users where username like concat('%','${value}','%')")
    List<Users> queryUserLike(@Param("value") String value);

}
