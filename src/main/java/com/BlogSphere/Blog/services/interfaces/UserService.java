package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.dtos.requests.UserLoginRequest;
import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.UserUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface UserService {

    ApiResponse registerUser(UserRegistrationRequest request) throws BlogException;


    ApiResponse updateProfile(UserUpdateProfileRequest request) throws BlogException;

    ApiResponse login(UserLoginRequest request) throws BlogException;

    User findByEmail(String userEmail);

    void save(User registeredUser);

    User findById(Long userId);
}
