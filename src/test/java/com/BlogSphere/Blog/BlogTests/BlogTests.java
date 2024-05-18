package com.BlogSphere.Blog.BlogTests;


import com.BlogSphere.Blog.data.models.Category;
import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.BlogService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BlogTests {
    @Autowired
    private BlogService blogService;


    @Test
    public void testThatABlogCanBeCreated() throws BlogException {
        BlogCreationRequest request = new BlogCreationRequest();
        request.setUserEmail("tobi4tee@gmail.com");
        request.setUserId(1L);
        request.setCategory(Category.SPORTS);
        request.setTitle("Sport News");
        request.setDescription("This is a new blog on sports");
        request.setCreatedAt(LocalDateTime.now());

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED).getStatusCode(),blogService.createBlog(request).getStatusCode());

    }

    @Test
    public void testThatAUserCanCreateMoreThankOneBlog() throws BlogException {
        BlogCreationRequest request = new BlogCreationRequest();
        request.setUserEmail("tobi4tee@gmail.com");
        request.setUserId(1L);
        request.setCategory(Category.ENTERTAINMENT);
        request.setTitle("Entertainment News");
        request.setDescription("Entertainment News");
        request.setCreatedAt(LocalDateTime.now());

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED).getStatusCode(),blogService.createBlog(request).getStatusCode());

    }
}
