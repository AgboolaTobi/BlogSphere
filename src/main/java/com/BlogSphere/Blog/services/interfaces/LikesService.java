package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.LikePostRequest;

public interface LikesService {

    void reactToPost(LikePostRequest request);
}
