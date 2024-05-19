package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
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
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private Category category;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Subscriber subscriber;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Likes> likes;
}
