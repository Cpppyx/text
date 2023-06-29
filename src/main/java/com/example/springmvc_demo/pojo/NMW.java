package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NMW {
    private String  the_id;
    private Integer department_count;
    private Integer male_event_count;
    private Integer female_even_count;
}
