package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;
    @NotBlank(message = "Content is mandatory to make comment")
    private String content;
    private int noOfLikes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Post post;

}
