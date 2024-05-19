package com.BlogSphere.Blog.dtos.requests;

import com.BlogSphere.Blog.data.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PostCreationRequest {
    private Long id;
    private Long userId;
    private Long blogId;
    private Category category;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
