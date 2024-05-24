package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Likes;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikesServiceApp implements LikesService {


    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    @Override
    public void reactToPost(LikePostRequest request) throws BlogException {
        Likes likes = new Likes();
        likes.setPostId(request.getPostId());
        likes.setUserId(request.getUserId());
        likes.setCreatedAt(request.getCreatedAt());
        Post existingPost = postRepository.findById(request.getPostId()).orElse(null);
        if (existingPost == null) throw new BlogException("Post does not exist");
        existingPost.setNoOfLikes(existingPost.getNoOfLikes() + 1);

        postRepository.save(existingPost);
        likeRepository.save(likes);

    }
}
