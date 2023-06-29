package com.example.springmvc_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Athlete_event {
    private Integer athlete_id;
    private Integer event_id;
    private Integer score;
    private Integer endowment_score;
    private String ranking;
}
