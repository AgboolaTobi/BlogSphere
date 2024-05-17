package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Post> posts;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Blog> blogs;
}
