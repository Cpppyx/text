package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String studentid;
    private String studentname;
    private String sex;
    private String phone;
    private Integer classid;
    private String classname;
    private Integer dormitoryid;

}
