package com.BlogSphere.Blog.LikesTests;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.repositories.CommentRepository;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.LikeCommentRequest;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.LikesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LikesTest {
    @Autowired
    private LikesService likesService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testThatAPostCanBeLiked() throws BlogException {

        LikePostRequest request = new LikePostRequest();
        request.setUserId(1L);
        request.setPostId(1L);


        Post post = postRepository.findById(request.getPostId()).orElse(null);
        assert post != null;
        int likes = post.getNoOfLikes();


        likesService.likePost(request);
        assertEquals(2,likes);

    }

    @Test
    public void testThatCommentMadeOnPostCanBeLiked() throws BlogException {
        LikeCommentRequest request = new LikeCommentRequest();
        request.setUserId(1L);
        request.setPostId(1L);
        request.setCommentId(1L);
        likesService.likeComment(request);
        Comment comment = commentRepository.findById(request.getCommentId()).orElse(null);
        assert comment != null;
        int likes = comment.getNoOfLikes();

        assertEquals(1,likes);

    }

}
