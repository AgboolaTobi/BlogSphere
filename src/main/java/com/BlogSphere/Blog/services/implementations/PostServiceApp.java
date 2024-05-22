package com.BlogSphere.Blog.services.implementations;


import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.services.interfaces.PostService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceApp implements PostService {
    private final PostRepository postRepository;

    @Override
    public ApiResponse createPost(PostCreationRequest request) {
        Post post = new Post();
        post.setUserId(request.getUserId());
        post.setBlogId(request.getBlogId());
        post.setCategory(request.getCategory());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedAt(request.getCreatedAt());

        postRepository.save(post);

        return GenerateApiResponse.created(GenerateApiResponse.POST_SUCCESSFULLY_MADE);
    }

    @Override
    public List<Comment> getAllComments(GetPostCommentsRequest request) {

        return null;
    }


}
