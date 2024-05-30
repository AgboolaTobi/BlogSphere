package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.dtos.requests.CommentRequest;
import com.BlogSphere.Blog.utils.ApiResponse;

public interface CommentService {
    ApiResponse createComment(CommentRequest request);

    Comment findById(Long commentId);

    void save(Comment comment);
}
