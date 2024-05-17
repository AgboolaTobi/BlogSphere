package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
