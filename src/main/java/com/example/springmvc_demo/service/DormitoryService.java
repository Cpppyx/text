package com.example.springmvc_demo.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormitoryService {
    public List<Dormitory> getList();
    public int add(Dormitory dormitory);
    List<Dormitory> queryLike(String value);
    public boolean delete(int id);
    Dormitory selectById(@Param("id") int id);
    public boolean update(Dormitory dormitory);
}
