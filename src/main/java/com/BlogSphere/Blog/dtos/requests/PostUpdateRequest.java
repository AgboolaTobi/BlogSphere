package com.BlogSphere.Blog.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostUpdateRequest {
    private Long postId;
    private String title;private
    String content;
}
