package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dormrepair {
    private Integer id;
    private String roomid;
    private String dormitoryname;
    private String username;
    private String repairtime;
    private String repairreason;
    private String repairstatus;
}
