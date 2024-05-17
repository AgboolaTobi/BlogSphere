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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private Blog blog;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Subscriber subscriber;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Reaction> reactions;
}
