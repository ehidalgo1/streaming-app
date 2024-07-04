package com.eugenio.streamming.app.model;

import com.google.cloud.Timestamp;
import lombok.*;

import java.util.List;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

    private String name;
    private String urlVideo;
    private String description;
    private int year;
    private int duration;
    private String country;
    private List<String> languages;
    private List<String> subtitles;
    private List<String> categories;
    private List<String> directors;
    private List<String> actors;
    private Timestamp createAt;
    private Timestamp updateAt;
    private boolean delete;

}
