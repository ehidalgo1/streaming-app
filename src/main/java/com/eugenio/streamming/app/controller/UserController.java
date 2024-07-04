package com.eugenio.streamming.app.controller;

import com.eugenio.streamming.app.model.common.Response;
import com.eugenio.streamming.app.model.user.User;
import com.eugenio.streamming.app.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            value = "user",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response> createUser(@RequestBody User user) {
        Response response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }
}
