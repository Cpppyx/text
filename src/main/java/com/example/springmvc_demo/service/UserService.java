package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Users;

import java.util.List;

public interface UserService {
    Users checkLoginUser(String name, String password);
    public int checkPower(String name, String password);
    public List<Users> getUserList();
    public int addUser(Users user);
    public boolean deleteUser(int id);
    public boolean updateUser(Users user);
    public boolean updateusers(Users user);
    Users selectUserById(int id);
    int addUsers(Users user);
    List<Users> queryUserLike(String value);

}

