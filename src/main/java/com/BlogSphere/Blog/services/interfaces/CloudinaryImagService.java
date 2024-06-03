package com.BlogSphere.Blog.services.interfaces;


import com.BlogSphere.Blog.dtos.requests.UploadImageRequest;
import com.BlogSphere.Blog.dtos.responses.UploadImageResponse;

import java.io.IOException;

public interface CloudinaryImagService {

    UploadImageResponse uploadImage(UploadImageRequest imageRequest) throws IOException;
}
