package com.BlogSphere.Blog.CommentTests;

import com.BlogSphere.Blog.dtos.requests.CommentRequest;
import com.BlogSphere.Blog.dtos.requests.LikeCommentRequest;
import com.BlogSphere.Blog.services.interfaces.CommentService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testThatPostCanBeCommentedOn(){
        CommentRequest request = new CommentRequest();
        request.setUserId(1L);
        request.setPostId(1L);
        request.setContent("This is a comment");
        request.setCreatedAt(LocalDateTime.now());

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.COMMENT_SUCCESSFULLY_SUBMITTED).getHttpStatus(),commentService.createComment(request).getHttpStatus());
    }

}
