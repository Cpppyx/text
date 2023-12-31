package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.Departments;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentsMapper {
    @Select("select * from departments")
    List<Departments> getdepartmentsList();
    @Insert("insert into departments(department_id,department_name,team_score) values (#{id},#{name},#{tscore}")
    int addDepartments(Departments departments);
    @Delete("delete from departments where department_id  = #{id}")
    boolean deleteDepartments(int id);
    @Update("update departments set department_name=#{name},team_score=#{score} where department_id=#{id}")
    boolean updateDepartments(Departments departments);
    @Select("select * from departments where department_id = #{id}")
    Departments selectDepartmentsById(@Param("id") int id);
    @Select("select sum(endowment_score) from athlete_event b\n" +
            "           where b.athlete_id in(\n" +
            "                select athlete_id from athletes a\n" +
            "                where a.department_id= #{id}\n" +
            "\n" +
            "               )")
    int totalPoints(@Param("id") int id);

}
