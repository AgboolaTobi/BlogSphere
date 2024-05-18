package com.BlogSphere.Blog.services;

import com.BlogSphere.Blog.data.models.Blog;
import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.BlogRepository;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceApp implements BlogService{

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse createBlog(BlogCreationRequest request) throws BlogException {
        User registeredUser = userRepository.findByEmail(request.getUserEmail());
        if (registeredUser == null) throw new BlogException("User not found");
        Blog newBlog = new Blog();
        newBlog.setUserId(registeredUser.getId());
        newBlog.setCategory(request.getCategory());
        newBlog.setTitle(request.getTitle());
        newBlog.setDescription(request.getDescription());
        newBlog.setCreatedAt(request.getCreatedAt());
        blogRepository.save(newBlog);
        userRepository.save(registeredUser);

        return GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED);

    }
}
