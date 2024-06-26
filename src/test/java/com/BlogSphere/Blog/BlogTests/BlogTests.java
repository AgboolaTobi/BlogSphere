package com.BlogSphere.Blog.BlogTests;


import com.BlogSphere.Blog.data.models.Category;
import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.dtos.requests.BlogUpdateRequest;
import com.BlogSphere.Blog.dtos.requests.GetAllPostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.BlogService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.PROFILE_UPDATED_SUCCESSFULLY).getHttpStatus(),
                blogService.createBlog(request).getHttpStatus());

    }

    @Test
    public void testThatAUserCanCreateMoreThanOneBlog() throws BlogException {
        BlogCreationRequest request = new BlogCreationRequest();
        request.setUserEmail("tobi4tee@gmail.com");
        request.setUserId(52L);
        request.setCategory(Category.ENTERTAINMENT);
        request.setTitle("Entertainment News");
        request.setDescription("Entertainment News");
        request.setCreatedAt(LocalDateTime.now());

        assertEquals(GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED).getStatusCode(),blogService.createBlog(request).getStatusCode());

    }

    @Test
    public void testThatAUserCanUpdateBlog() throws BlogException {
        BlogUpdateRequest request = new BlogUpdateRequest();
        request.setBlogId(1L);
        request.setTitle("A new updated blog");
        request.setDescription("Updated Sports news");
        request.setUpdatedAt(LocalDateTime.now());

        assertEquals(GenerateApiResponse.updated(GenerateApiResponse.BLOG_UPDATED_SUCCESSFULLY).getStatusCode(),blogService.updateBlog(request).getStatusCode());


    }

    @Test
    public void testThatAUserCanGetAllPostsInABlog() throws BlogException {
        GetAllPostRequest request = new GetAllPostRequest();
        request.setBlogId(1L);
        assertThat(blogService.getAllPosts(request)).isNotNull();
    }


}
