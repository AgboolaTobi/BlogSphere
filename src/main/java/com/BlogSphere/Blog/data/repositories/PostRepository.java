package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
