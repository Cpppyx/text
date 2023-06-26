package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.User;

import java.util.List;

public interface UserService {
    User checkLoginUser(String name, String password);
    public int checkPower(String name, String password);
    public List<User> getUserList();
    public int addUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public boolean updateusers(User user);
    User selectUserById(int id);
    int addUsers(User user);
    List<User> queryUserLike(String value);

}

