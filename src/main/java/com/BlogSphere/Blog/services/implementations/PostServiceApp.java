package com.BlogSphere.Blog.services.implementations;


import com.BlogSphere.Blog.data.models.Comment;
import com.BlogSphere.Blog.data.models.Post;
import com.BlogSphere.Blog.data.models.User;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.services.interfaces.PostService;
import com.BlogSphere.Blog.services.interfaces.UserService;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceApp implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public ApiResponse createPost(PostCreationRequest request) {

        User existingUser = userService.findById(request.getUserId());
        Post post = new Post();
        post.setUserId(request.getUserId());
        post.setBlogId(request.getBlogId());
        post.setCategory(request.getCategory());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedAt(request.getCreatedAt());

        postRepository.save(post);
        userService.save(existingUser);

        return GenerateApiResponse.created(GenerateApiResponse.POST_SUCCESSFULLY_MADE);
    }

    @Override
    public List<Comment> getAllComments(GetPostCommentsRequest request) {

        return null;
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public void save(Post existingPost) {
        postRepository.save(existingPost);
    }


}
