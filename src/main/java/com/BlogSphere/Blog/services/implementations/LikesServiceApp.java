package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.models.Likes;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.repositories.CommentRepository;
import com.BlogSphere.Blog.data.repositories.LikeRepository;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.LikeCommentRequest;
import com.BlogSphere.Blog.dtos.requests.LikePostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LikesServiceApp implements LikesService {


    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public void likePost(LikePostRequest request) throws BlogException {
        Likes likes = new Likes();
        likes.setPostId(request.getPostId());
        likes.setUserId(request.getUserId());
        likes.setCreatedAt(LocalDateTime.now());
        Post existingPost = postRepository.findById(request.getPostId()).orElse(null);
        if (existingPost == null) throw new BlogException("Post does not exist");
        existingPost.setNoOfLikes(existingPost.getNoOfLikes() + 1);

        postRepository.save(existingPost);
        likeRepository.save(likes);

    }

    @Override
    public void likeComment(LikeCommentRequest request) throws BlogException {
        Likes likes = new Likes();
        likes.setUserId(request.getUserId());
        likes.setPostId(request.getPostId());
        likes.setCommentId(request.getCommentId());
        likes.setCreatedAt(LocalDateTime.now());
        Post existingPost = postRepository.findById(request.getPostId()).orElse(null);
        if (existingPost == null) throw new BlogException("Post does not exist");
        Comment comment = commentRepository.findById(request.getCommentId()).orElse(null);
        if (comment == null) throw new BlogException("Comment does not exist");
        comment.setNoOfLikes(comment.getNoOfLikes() + 1);

        commentRepository.save(comment);
        likeRepository.save(likes);
        postRepository.save(existingPost);
    }
}
