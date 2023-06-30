package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.DepartmentsMapper;
import com.example.springmvc_demo.pojo.Departments;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
    @Resource
    DepartmentsMapper departmentsMapper;

    @Override
    public List<Departments> getdepartmentsList() {
        return departmentsMapper.getdepartmentsList();
    }

    @Override
    public int addDepartments(Departments departments) {
        return departmentsMapper.addDepartments(departments);
    }

    @Override
    public boolean deleteDepartments(int id) {
        return departmentsMapper.deleteDepartments(id);
    }

    @Override
    public boolean updateDepartments(Departments departments) {
        return departmentsMapper.updateDepartments(departments);
    }

    @Override
    public Departments selectDepartmentsById(int id) {
        return departmentsMapper.selectDepartmentsById(id);
    }
}
