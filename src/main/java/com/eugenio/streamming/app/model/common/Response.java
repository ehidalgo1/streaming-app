package com.eugenio.streamming.app.model.common;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    private int code;
    private String status;
    private List<String> errors = new ArrayList<>();
    private Object payload;
}
