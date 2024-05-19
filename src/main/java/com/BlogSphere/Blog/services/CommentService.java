package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.dtos.requests.CommentRequest;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface CommentService {
    ApiResponse createComment(CommentRequest request);
}
