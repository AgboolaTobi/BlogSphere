package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface BlogService {
    ApiResponse createBlog(BlogCreationRequest request) throws BlogException;
}
