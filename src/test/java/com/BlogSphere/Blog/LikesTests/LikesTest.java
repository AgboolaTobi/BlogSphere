package com.BlogSphere.Blog.LikesTests;

import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.services.LikesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class LikesTest {
    @Autowired
    private LikesService likesService;

    @Test
    public void testThatAPostCanBeLiked(){

        LikePostRequest request = new LikePostRequest();
        request.setUserId(1L);
        request.setPostId(2L);
        request.setCreatedAt(LocalDateTime.now());

        likesService.reactToPost(request);

    }
}
