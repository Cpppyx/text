package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.DormitoryMapper;
import com.example.springmvc_demo.pojo.Dormitory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService{
    @Resource
    DormitoryMapper mapper;

    @Override
    public List<Dormitory> getList(){
        return mapper.getList();
    }

    @Override
    public int add(Dormitory dormitory){
        return mapper.add(dormitory);
    }

    @Override
    public List<Dormitory> queryLike(String value){
        return mapper.queryLike(value);
    }

    @Override
    public boolean delete(int id){
        return mapper.delete(id);
    }

    @Override
    public Dormitory selectById(int id){
        return mapper.selectById(id);
    }

    @Override
    public boolean update(Dormitory dormitory){
        return mapper.update(dormitory);
    }

}
