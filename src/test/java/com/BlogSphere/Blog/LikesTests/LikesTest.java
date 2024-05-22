package com.BlogSphere.Blog.LikesTests;

import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
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
    private LikeRepository likeRepository;

    @Test
    public void testThatAPostCanBeLiked(){

        LikePostRequest request = new LikePostRequest();
        request.setUserId(1L);
        request.setPostId(1L);
        request.setCreatedAt(LocalDateTime.now());

        likesService.reactToPost(request);
        assertEquals(1,likeRepository.count());

    }
}
