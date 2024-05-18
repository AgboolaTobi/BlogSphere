package com.BlogSphere.Blog.dtos.requests;


import com.BlogSphere.Blog.data.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlogCreationRequest {
    private String userEmail;
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Category category;
}
