package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.dtos.requests.BlogUpdateRequest;
import com.BlogSphere.Blog.dtos.requests.GetAllPostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;

import java.util.List;

public interface BlogService {
    ApiResponse createBlog(BlogCreationRequest request) throws BlogException;


    ApiResponse updateBlog(BlogUpdateRequest request) throws BlogException;

    List<Post> getAllPosts(GetAllPostRequest request) throws BlogException;
}
