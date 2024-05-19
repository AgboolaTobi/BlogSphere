package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long postId;
    private LocalDateTime createdAt;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Post post;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private User user;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Subscriber subscriber;

}