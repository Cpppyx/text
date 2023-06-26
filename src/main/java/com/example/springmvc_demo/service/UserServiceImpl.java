package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.UserMapper;
import com.example.springmvc_demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;
    @Override
    public User checkLoginUser(String username, String password) {
        return mapper.checkLoginUser(username,password);
    }

    @Override
    public List<User> getUserList() {
        return mapper.getUserList();
    }
    @Override
    public int addUser(User user){
        return mapper.addUser(user);
    }
    @Override
    public boolean deleteUser(int id){
        return mapper.deleteUser(id);
    }
    @Override
    public boolean updateUser(User user){
        return mapper.updateUser(user);
    }
    @Override
    public int checkPower(String name, String password){
        return mapper.checkPower(name, password);
    }
    @Override
    public boolean updateusers(User user){
        return mapper.updateusers(user);
    }
    @Override
    public User selectUserById(int id){
        return mapper.selectUserById(id);
    }
    @Override
    public int addUsers(User user){
        return mapper.addUsers(user);
    }
    @Override
    public List<User> queryUserLike(String value){
        return mapper.queryUserLike(value);
    }
}