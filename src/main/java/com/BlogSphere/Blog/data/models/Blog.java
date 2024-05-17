package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

}
