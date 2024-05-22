package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Likes;
import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.services.interfaces.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikesServiceApp implements LikesService {


    private final LikeRepository likeRepository;

    @Override
    public void reactToPost(LikePostRequest request) {
        Likes likes = new Likes();
        likes.setPostId(request.getPostId());
        likes.setUserId(request.getUserId());
        likes.setCreatedAt(request.getCreatedAt());
        likeRepository.save(likes);

    }
}
