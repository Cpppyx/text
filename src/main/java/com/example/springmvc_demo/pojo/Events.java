package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Events {
    private Integer event_id;
    private String event_name;
    private String event_type;
    private String event_location;
    private String event_date;
}
