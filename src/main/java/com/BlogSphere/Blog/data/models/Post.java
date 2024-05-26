package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long blogId;
    @NotBlank(message = "Post Title is mandatory")
    private String title;
    @NotBlank(message = "Post content is mandatory")
    private String content;
    private int noOfLikes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Kindly state a category for your post")
    private Category category;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Likes> likes;
}
