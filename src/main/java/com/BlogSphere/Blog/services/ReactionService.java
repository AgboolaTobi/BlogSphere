package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.data.models.Reaction;
import com.BlogSphere.Blog.dtos.requests.ReactionRequest;
import com.BlogSphere.Blog.dtos.responses.ReactionResponse;
import org.springframework.boot.web.server.ErrorPage;

public interface ReactionService {
    void reactToPost(ReactionRequest request);
}
