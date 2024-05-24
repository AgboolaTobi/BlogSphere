package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikeCommentRequest {
    private Long userId;
    private Long postId;
    private Long commentId;
    private String comment;

}
