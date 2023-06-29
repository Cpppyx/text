package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departments {
    private Integer department_id ;
    private String department_name;
    private Integer team_score;


}
