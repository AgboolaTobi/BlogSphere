package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Blog> blogs;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;
    @ManyToOne(fetch = FetchType.EAGER)
    private Subscriber subscriber;
}
