package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.UserRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.UserUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface UserService {

    ApiResponse registerUser(UserRegistrationRequest request) throws BlogException;


    ApiResponse updateProfile(UserUpdateProfileRequest request) throws BlogException;
}
