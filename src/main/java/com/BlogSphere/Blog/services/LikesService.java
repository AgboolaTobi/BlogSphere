package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.dtos.requests.ReactionRequest;

public interface LikesService {

    void reactToPost(ReactionRequest request);
}
