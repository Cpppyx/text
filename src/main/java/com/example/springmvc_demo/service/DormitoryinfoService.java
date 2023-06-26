package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Dormitoryinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormitoryinfoService {
    public List<Dormitoryinfo> getList();
    public int add(Dormitoryinfo dormitoryinfo);
    List<Dormitoryinfo> queryLike(String value);
    public boolean delete(int id);
    Dormitoryinfo selectById(int id);
    public boolean updat(Dormitoryinfo dormitoryinfo);
    public  List<Dormitoryinfo> getList1(String username);
    public  List<Dormitoryinfo> getList2(String username);
    List<Dormitoryinfo> queryLike2(String username,String value);

}
