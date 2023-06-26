package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.DormitoryinfoMapper;
import com.example.springmvc_demo.pojo.Dormitoryinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DormitoryinfoServiceImpl implements DormitoryinfoService{
    @Resource
    DormitoryinfoMapper mapper;

    @Override
    public List<Dormitoryinfo> getList(){
        return mapper.getList();
    }

    @Override
    public int add(Dormitoryinfo dormitoryinfo){
        return mapper.add(dormitoryinfo);
    }

    @Override
    public List<Dormitoryinfo> queryLike(String value){
        return mapper.queryLike(value);
    }

    @Override
    public boolean delete(int id){
        return mapper.delete(id);
    }

    @Override
    public Dormitoryinfo selectById(int id){
        return mapper.selectById(id);
    }

    @Override
    public boolean updat(Dormitoryinfo dormitoryinfo){
        return mapper.updat(dormitoryinfo);
    }

    @Override
    public  List<Dormitoryinfo> getList1(String username){
        return mapper.getList1(username);
    }

    @Override
    public  List<Dormitoryinfo> getList2(String username){
        return mapper.getList2(username);
    }

    @Override
    public List<Dormitoryinfo> queryLike2(String username,String value){
        return mapper.queryLike2(username,value);
    }
}
