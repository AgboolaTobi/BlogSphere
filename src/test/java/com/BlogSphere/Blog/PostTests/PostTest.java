package com.BlogSphere.Blog.PostTests;

import com.BlogSphere.Blog.data.models.Category;
import com.BlogSphere.Blog.data.repositories.CommentRepository;
import com.BlogSphere.Blog.dtos.requests.GetPostCommentsRequest;
import com.BlogSphere.Blog.dtos.requests.PostCreationRequest;
import com.BlogSphere.Blog.dtos.requests.UploadImageRequest;
import com.BlogSphere.Blog.services.interfaces.PostService;
import com.BlogSphere.Blog.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testThatARegisteredUserWithABlogCanCreateAPost() throws IOException {
        List<MultipartFile> files = new ArrayList<>();
        PostCreationRequest request = new PostCreationRequest();
        request.setUserId(1L);
        request.setBlogId(1L);
        request.setCategory(Category.SPORTS);
        request.setTitle("23/24 La liga Rounds up");
        request.setContent("A quick look at the tables as the season closes in...");
        request.setCreatedAt(LocalDateTime.now());
        UploadImageRequest request1 = new UploadImageRequest();
        File file1 = new File("C:\\Users\\Dell\\Pictures\\Camera Roll\\WIN_20240314_15_15_40_Pro.jpg");
        FileInputStream inputStream = new FileInputStream(file1);
        MultipartFile multipartFile = new MockMultipartFile(
                "file", inputStream);
        files.add(multipartFile);
        request1.setImages(files);
        request.setImageRequest(request1);
        assertEquals(GenerateApiResponse.created(GenerateApiResponse.POST_SUCCESSFULLY_MADE).getStatusCode(),postService.createPost(request).getStatusCode());

    }


}
