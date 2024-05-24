package com.BlogSphere.Blog.LikesTests;

import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.LikesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LikesTest {
    @Autowired
    private LikesService likesService;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void testThatAPostCanBeLiked() throws BlogException {

        LikePostRequest request = new LikePostRequest();
        request.setUserId(1L);
        request.setPostId(1L);
        request.setCreatedAt(LocalDateTime.now());

        Post post = postRepository.findById(request.getPostId()).orElse(null);
        assert post != null;
        int likes = post.getNoOfLikes();


        likesService.reactToPost(request);
        assertEquals(4,likes);

    }
}
