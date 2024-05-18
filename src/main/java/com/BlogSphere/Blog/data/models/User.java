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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Blog> blogs;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Subscriber subscriber;
}
