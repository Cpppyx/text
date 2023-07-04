package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.Departments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentsService {

    List<Departments> getdepartmentsList();

    int addDepartments(Departments departments);

    boolean deleteDepartments(int id);

    boolean updateDepartments(Departments departments);

    Departments selectDepartmentsById(@Param("id") int id);

    int totalPoints(int id);

}
