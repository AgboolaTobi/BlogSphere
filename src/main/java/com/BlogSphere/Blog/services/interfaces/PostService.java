package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.utils.ApiResponse;

import java.io.IOException;
import java.util.List;

public interface PostService {
    ApiResponse createPost(PostCreationRequest request) throws IOException;

    List<Comment> getAllComments(GetPostCommentsRequest request);

    Post findById(Long postId);

    void save(Post existingPost);

}
