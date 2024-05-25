package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.AdminLoginRequest;
import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.requests.AdminUpdateProfileRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface AdminService {
    ApiResponse registerAdmin(AdminRegistrationRequest request) throws BlogException;

    ApiResponse login(AdminLoginRequest request) throws BlogException;

    ApiResponse updateProfile(AdminUpdateProfileRequest request) throws BlogException;
}
