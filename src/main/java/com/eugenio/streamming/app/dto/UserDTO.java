package com.eugenio.streamming.app.dto;

import com.eugenio.streamming.app.model.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String name;
    private List<Role> roles;
}
