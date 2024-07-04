package com.eugenio.streamming.app.util;

import com.eugenio.streamming.app.dto.UserDTO;
import com.eugenio.streamming.app.model.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtil {

    private static final ModelMapper mapper = new ModelMapper();

    public static UserDTO toDto(User user) {
        return mapper.map(user, UserDTO.class);
    }

    public static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
