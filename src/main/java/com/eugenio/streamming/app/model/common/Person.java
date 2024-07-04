package com.eugenio.streamming.app.model.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private String birthdate;
}
