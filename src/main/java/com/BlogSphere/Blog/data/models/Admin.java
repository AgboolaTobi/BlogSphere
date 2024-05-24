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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;
    private boolean isLogin;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Blog> blogs;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

}
