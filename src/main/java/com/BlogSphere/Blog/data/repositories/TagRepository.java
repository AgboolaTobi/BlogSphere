package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
