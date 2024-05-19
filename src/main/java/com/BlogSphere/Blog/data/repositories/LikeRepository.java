package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {

}
