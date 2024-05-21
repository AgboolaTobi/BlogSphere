package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LikePostRequest {
    private Long userId;
    private Long postId;
    private LocalDateTime createdAt;
}
