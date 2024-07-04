package com.eugenio.streamming.app.dto;

import com.google.cloud.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieDTO {
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
}
