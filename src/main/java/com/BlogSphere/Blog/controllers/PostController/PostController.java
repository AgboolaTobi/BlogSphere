package com.BlogSphere.Blog.controllers.PostController;

import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.services.interfaces.PostService;
import com.BlogSphere.Blog.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/post/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("post")
    public ResponseEntity<ApiResponse> makePost(@RequestBody PostCreationRequest request) throws IOException {
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }
}
