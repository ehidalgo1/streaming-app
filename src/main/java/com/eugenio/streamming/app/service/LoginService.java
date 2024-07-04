package com.eugenio.streamming.app.service;

import com.eugenio.streamming.app.dto.UserDTO;
import com.eugenio.streamming.app.model.user.User;
import com.eugenio.streamming.app.repository.UserRepository;
import com.eugenio.streamming.app.util.UserUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO login(User user) {
        User userFromDb = userRepository.getUserByUsername(user.getUsername());
        if (verifyPassword(user.getPassword(), userFromDb.getPassword())) {
            return UserUtil.toDto(userFromDb);
        }
        throw new RuntimeException("No encontrado");
    }

    private boolean verifyPassword(String passwordValidate, String originalPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(passwordValidate, originalPassword);
    }
}
