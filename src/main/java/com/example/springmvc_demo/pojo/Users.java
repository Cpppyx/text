package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private Integer user_id;
    private String role;
    private String username;
    private String password;
    private String avatar;
    //0-管理员
    //1-裁判
    private Integer power;

}
