package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String avatar;
    //0-管理员
    //1-学生
    //2-辅导员
    //3-宿舍管理员
    private Integer power;

}
