package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostCommentsRequest {
    private Long postId;
}
