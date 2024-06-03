package com.BlogSphere.Blog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class BlogCreationResponse {
    private Long blogId;
    private String message;
}
