package com.example.springmvc_demo.mapper;

import com.example.springmvc_demo.pojo.NMW;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NMWMapper {
    @Select("select * from nmv")
    List<NMW> getnmvList();
    @Insert("insert into nmv(the_id,department_count,male_event_count,female_even_count) values (#{id},#{name},#{time},#{type},#{location},#{date})")
    int addnmv(NMW nmw);
    @Delete("delete from nmv where the_id = #{id}")
    boolean deleteNMV(int id);
    @Update("update nmv set department_count=#{department_count},male_event_count=#{male_event_count},female_even_count=#{female_even_count} where the_id=#{id}")
    boolean updatenmv(NMW nmw);
    @Select("select * from nmv where ethe_id = #{id}")
    NMW selectNmvById(@Param("id") int id);

}
