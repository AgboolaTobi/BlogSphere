package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikePostRequest {
    private Long userId;
    private Long postId;

}
