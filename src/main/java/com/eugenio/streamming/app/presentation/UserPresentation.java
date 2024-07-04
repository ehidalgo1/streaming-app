package com.eugenio.streamming.app.presentation;

import com.eugenio.streamming.app.model.common.Response;
import com.eugenio.streamming.app.model.user.User;
import com.eugenio.streamming.app.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserPresentation {

    private final UserService userService;

    public UserPresentation(UserService userService) {
        this.userService = userService;
    }

    public Response createUser(User user) {
        return userService.createUser(user);
    }
}
