package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.repositories.CommentRepository;
import com.BlogSphere.Blog.dtos.requests.CommentRequest;
import com.BlogSphere.Blog.services.interfaces.CommentService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceApp implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public ApiResponse createComment(CommentRequest request) {
        Comment comment = new Comment();
        comment.setUserId(request.getUserId());
        comment.setPostId(request.getPostId());
        comment.setContent(request.getContent());
        comment.setCreatedAt(request.getCreatedAt());
        commentRepository.save(comment);

        return GenerateApiResponse.created(GenerateApiResponse.COMMENT_SUCCESSFULLY_SUBMITTED);
    }
}
