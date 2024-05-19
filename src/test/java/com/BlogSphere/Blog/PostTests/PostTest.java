package com.BlogSphere.Blog.PostTests;

import com.BlogSphere.Blog.data.models.Category;
import com.BlogSphere.Blog.data.repositories.PostRepository;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.services.PostService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostService postService;
    @Test
    public void testThatARegisteredUserWithABlogCanCreateAPost() {
        PostCreationRequest request = new PostCreationRequest();
        request.setUserId(1L);
        request.setBlogId(1L);
        request.setCategory(Category.SPORTS);
        request.setTitle("23/24 La liga Rounds up");
        request.setContent("A quick look at the tables as the season closes in...");
        request.setCreatedAt(LocalDateTime.now());


        assertEquals(GenerateApiResponse.created(GenerateApiResponse.POST_SUCCESSFULLY_MADE).getStatusCode(),postService.createPost(request).getStatusCode());

    }
}
