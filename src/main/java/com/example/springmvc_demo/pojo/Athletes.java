package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Athletes {
    private Integer athlete_id;
    private String athlete_name;
    private String gender;
    private Integer age;
    private String  event_type;
    private Integer department_id;
}
