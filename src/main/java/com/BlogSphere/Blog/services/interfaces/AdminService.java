package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.AdminRegistrationRequest;
import com.BlogSphere.Blog.dtos.responses.AdminRegistrationResponse;
import com.BlogSphere.Blog.exceptions.BlogException;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws BlogException;

}
