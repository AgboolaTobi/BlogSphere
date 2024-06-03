package com.BlogSphere.Blog.services.implementations;


import com.BlogSphere.Blog.data.models.*;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.data.repositories.UserRepository;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.dtos.responses.UploadImageResponse;
import com.BlogSphere.Blog.services.interfaces.*;
import com.BlogSphere.Blog.utils.ApiResponse;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceApp implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CloudinaryImagService cloudinaryService;
    private final ImageService imageService;
    private final BlogService blogService;

    @Override
    public ApiResponse createPost(PostCreationRequest request) throws IOException {

        User existingUser = userService.findById(request.getUserId());
        List<Post> existingUserPosts = existingUser.getPosts();
        Post post = new Post();
        post.setUserId(request.getUserId());
        post.setBlogId(request.getBlogId());
        post.setCategory(request.getCategory());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedAt(request.getCreatedAt());
        existingUserPosts.add(post);
        UploadImageResponse response =  cloudinaryService.uploadImage(request.getImageRequest());
        List<Image> images = imageService.saveImage(response);
        post.setImage(images);
        postRepository.save(post);
        blogService.add(post,request.getBlogId());

//        userService.save(existingUser);

        userRepository.save(existingUser);
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
