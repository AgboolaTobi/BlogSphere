package com.BlogSphere.Blog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UploadImageResponse {
    private List<String> url;
}
