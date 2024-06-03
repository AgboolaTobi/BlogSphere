package com.BlogSphere.Blog.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String imageUrl;

}
