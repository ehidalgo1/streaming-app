package com.eugenio.streamming.app.service;

import com.eugenio.streamming.app.dto.UserDTO;
import com.eugenio.streamming.app.model.common.Response;
import com.eugenio.streamming.app.model.user.User;
import com.eugenio.streamming.app.repository.UserRepository;
import com.eugenio.streamming.app.util.UserUtil;
import com.google.cloud.Timestamp;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public Response createUser(User user) {
        try {
            // valid if user exist
            User user1 = userRepository.getUserByUsername(user.getUsername());
            if (user1 != null) {
                return Response.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .errors(List.of("el usuario ya existe"))
                        .build();
            }
            // set the hash password
            String passwordHashed = UserUtil.hashPassword(user.getPassword());
            user.setPassword(passwordHashed);
            // set the creation date
            user.setCreateAt(Timestamp.now());
            return Response.builder()
                    .code(201)
                    .payload(mapper.map(
                            userRepository.createUser(user),
                            UserDTO.class)
                    )
                    .build();
        } catch (Exception e) {
            log.error("Error to create user: {}", e.getMessage());
            return Response.builder()
                    .code(500)
                    .errors(List.of("error to create user"))
                    .build();
        }

    }


}
