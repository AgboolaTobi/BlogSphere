package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long blogId;
    private String title;
    private String content;
    private int noOfLikes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private List<Image> image;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Likes> likes;
}
