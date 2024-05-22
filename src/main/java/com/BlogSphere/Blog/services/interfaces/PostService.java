package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.utils.ApiResponse;

import java.util.List;

public interface PostService {
    ApiResponse createPost(PostCreationRequest request);

    List<Comment> getAllComments(GetPostCommentsRequest request);
}
