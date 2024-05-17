package com.BlogSphere.Blog.data.repositories;

import com.BlogSphere.Blog.data.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
