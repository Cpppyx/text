package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.DormrepairMapper;
import com.example.springmvc_demo.pojo.Dormrepair;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormrepairSerciceImpl implements DormrepairSercice{
    @Resource
    DormrepairMapper mapper;

    @Override
    public List<Dormrepair> getList(String username) {
        return mapper.getList(username);
    }

    @Override
    public List<Dormrepair> queryLike(String value) {
        return mapper.queryLike(value);
    }

    @Override
    public int add(Dormrepair dormrepair) {
        return mapper.add(dormrepair);
    }

    @Override
    public boolean delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public boolean update(Dormrepair dormrepair) {
        return mapper.update(dormrepair);
    }

    @Override
    public Dormrepair selectById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Dormrepair> getList1() {
        return mapper.getList1();
    }
}
