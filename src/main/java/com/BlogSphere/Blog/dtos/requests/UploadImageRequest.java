package com.BlogSphere.Blog.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter

public class UploadImageRequest {
    private List<MultipartFile> images;

}
