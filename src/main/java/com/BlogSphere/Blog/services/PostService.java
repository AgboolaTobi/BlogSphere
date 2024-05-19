package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface PostService {
    ApiResponse createPost(PostCreationRequest request);
}
