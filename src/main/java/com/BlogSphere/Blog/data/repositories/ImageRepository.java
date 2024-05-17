package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
