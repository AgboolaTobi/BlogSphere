package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
