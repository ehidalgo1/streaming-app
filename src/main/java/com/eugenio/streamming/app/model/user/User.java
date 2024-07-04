package com.eugenio.streamming.app.model.user;

import com.eugenio.streamming.app.model.Preferences;
import com.eugenio.streamming.app.model.common.Person;
import com.google.cloud.Timestamp;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    private String username;
    private String password;
    private List<Role> roles;
    private Preferences preferences;
    private Timestamp createAt;
    private Timestamp updateAt;
    private boolean disable;

}
