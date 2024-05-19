package com.BlogSphere.Blog.reactionTests;

import com.BlogSphere.Blog.dtos.requests.ReactionRequest;
import com.BlogSphere.Blog.dtos.responses.ReactionResponse;
import com.BlogSphere.Blog.services.ReactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReactionTest {

    @Autowired
    private ReactionService reactionService;

    @Test
    public void testThatAPostCanBeReactedTo() {
        ReactionRequest request = new ReactionRequest();
        request.setUserId(1L);
        request.setPostId(2L);
        reactionService.reactToPost(request);

        ReactionResponse response = new ReactionResponse();
        response.setMessage("Reaction Successfully submitted");

        assertThat(response).isNotNull();

    }
}
