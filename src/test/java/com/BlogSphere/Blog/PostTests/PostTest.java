package com.BlogSphere.Blog.PostTests;

import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTest {

    @Test
    public void testThatARegisteredUserWithABlogCanCreateAPost() {
        PostCreationRequest request = new PostCreationRequest();
    }
}
