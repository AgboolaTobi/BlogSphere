package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Blog;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.BlogRepository;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.BlogCreationRequest;
import com.BlogSphere.Blog.dtos.requests.BlogUpdateRequest;
import com.BlogSphere.Blog.dtos.requests.GetAllPostRequest;
import com.BlogSphere.Blog.exceptions.BlogException;
import com.BlogSphere.Blog.services.interfaces.BlogService;
import com.BlogSphere.Blog.services.interfaces.UserService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogServiceApp implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public ApiResponse createBlog(BlogCreationRequest request) throws BlogException {
        User registeredUser = userService.findByEmail(request.getUserEmail());
        if (registeredUser == null) throw new BlogException("User not found");
        Blog newBlog = new Blog();
        newBlog.setUserId(registeredUser.getId());
        newBlog.setCategory(request.getCategory());
        newBlog.setTitle(request.getTitle());
        newBlog.setDescription(request.getDescription());
        newBlog.setCreatedAt(request.getCreatedAt());
        blogRepository.save(newBlog);
        userService.save(registeredUser);

        return GenerateApiResponse.created(GenerateApiResponse.BLOG_SUCCESSFULLY_CREATED);

    }

    @Override
    public ApiResponse updateBlog(BlogUpdateRequest request) throws BlogException {

        Optional<Blog> existingBlog = blogRepository.findById(request.getBlogId());
        Blog updatedBlog = existingBlog.orElseThrow(() -> new BlogException("Blog not found"));
        updatedBlog.setTitle(request.getTitle());
        updatedBlog.setDescription(request.getDescription());
        updatedBlog.setUpdatedAt(request.getUpdatedAt());
        blogRepository.save(updatedBlog);
        return GenerateApiResponse.updated(GenerateApiResponse.BLOG_UPDATED_SUCCESSFULLY);


    }

    @Override
    public List<Post> getAllPosts(GetAllPostRequest request) throws BlogException {
        Blog blog = blogRepository.findById(request.getBlogId()).orElse(null);
        if (blog==null) throw new BlogException(GenerateApiResponse.BLOG_NOT_FOUND);
        return blog.getPosts();

    }


}
