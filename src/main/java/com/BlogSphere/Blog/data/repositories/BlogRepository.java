package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
