package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dormitoryinfo {
    private Integer id;
    private String roomid;
    private String dormitoryname;
    private String bedid;
    private String username;
    private String  userid;
}
