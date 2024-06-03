package com.BlogSphere.Blog.services.interfaces;

import com.BlogSphere.Blog.data.models.Image;
import com.BlogSphere.Blog.dtos.responses.UploadImageResponse;

import java.util.List;

public interface ImageService {
    List<Image> saveImage(UploadImageResponse response);
}
