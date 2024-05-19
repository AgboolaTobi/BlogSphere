package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.data.models.Likes;
import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.dtos.requests.ReactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikesServiceApp implements LikesService {


    private final LikeRepository likeRepository;

    @Override
    public void reactToPost(ReactionRequest request) {
        Likes likes = new Likes();
        likes.setPostId(request.getPostId());
        likes.setUserId(request.getUserId());
        likes.setCreatedAt(request.getCreatedAt());
        likeRepository.save(likes);

    }
}
