package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Reaction, Long> {

}
