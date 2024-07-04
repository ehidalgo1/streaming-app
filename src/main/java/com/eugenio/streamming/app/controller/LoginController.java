package com.eugenio.streamming.app.controller;

import com.eugenio.streamming.app.dto.UserDTO;
import com.eugenio.streamming.app.model.user.User;
import com.eugenio.streamming.app.service.LoginService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(
            value = "login",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        return ResponseEntity.of(
                Optional.of(loginService.login(user))
        );
    }
}
