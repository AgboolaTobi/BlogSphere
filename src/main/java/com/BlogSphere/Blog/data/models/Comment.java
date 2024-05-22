package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
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
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Post post;

}
