package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private Role role;
    @OneToMany(fetch = FetchType.EAGER)
    private List<User> users;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Blog> blogs;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;

}
