package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.dtos.requests.LikePostRequest;

public interface LikesService {

    void reactToPost(LikePostRequest request);
}
