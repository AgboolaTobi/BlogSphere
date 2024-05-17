package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
