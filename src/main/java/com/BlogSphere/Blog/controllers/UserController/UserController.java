package com.BlogSphere.Blog.controllers.UserController;

import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.UserService;
import com.BlogSphere.Blog.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRegistrationRequest request) {
        try {
            return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
        } catch (BlogException exception) {
            throw new RuntimeException(exception);
        }
    }
}
