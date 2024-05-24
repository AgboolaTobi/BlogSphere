package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.LikeCommentRequest;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;

public interface LikesService {

    void likePost(LikePostRequest request) throws BlogException;

    void likeComment(LikeCommentRequest request) throws BlogException;
}
