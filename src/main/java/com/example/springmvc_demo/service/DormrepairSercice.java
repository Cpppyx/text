package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Dormrepair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormrepairSercice {
    public List<Dormrepair> getList(String username);
    public List<Dormrepair> queryLike(String value);
    public int add(Dormrepair dormrepair);
    public boolean delete(int id);
    public boolean update(Dormrepair dormrepair);
    public Dormrepair selectById(int id);
    public List<Dormrepair> getList1();
}
