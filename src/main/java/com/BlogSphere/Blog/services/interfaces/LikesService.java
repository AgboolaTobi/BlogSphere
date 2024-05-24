package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;

public interface LikesService {

    void reactToPost(LikePostRequest request) throws BlogException;
}
