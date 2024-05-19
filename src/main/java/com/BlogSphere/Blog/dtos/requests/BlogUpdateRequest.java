package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlogUpdateRequest {
    private Long blogId;
    private String title;
    private String description;
    private LocalDateTime updatedAt;
}
