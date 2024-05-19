package com.BlogSphere.Blog.services;


import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceApp implements PostService{
    private final PostRepository postRepository;

    @Override
    public ApiResponse createPost(PostCreationRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setBlogId(request.getBlogId());
        post.setCategory(request.getCategory());
        post.setCreatedAt(request.getCreatedAt());

        postRepository.save(post);

        return GenerateApiResponse.created(GenerateApiResponse.POST_SUCCESSFULLY_MADE);
    }
}