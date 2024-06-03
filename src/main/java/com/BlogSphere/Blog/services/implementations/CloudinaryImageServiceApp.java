package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.configs.CloudinaryConfig;
import com.BlogSphere.Blog.dtos.requests.UploadImageRequest;
import com.BlogSphere.Blog.dtos.responses.UploadImageResponse;
import com.BlogSphere.Blog.services.interfaces.CloudinaryImagService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class CloudinaryImageServiceApp implements CloudinaryImagService {
    private final Cloudinary cloudinary;


    @Override
    public UploadImageResponse uploadImage(UploadImageRequest imageRequest) throws IOException {
        UploadImageResponse response = new UploadImageResponse();
        List<String> urls = new ArrayList<>();
        for (MultipartFile multipartFile : imageRequest.getImages()) {
            Map uploadedResult  = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            String url = uploadedResult.get("url").toString();
            urls.add(url);
        }
        response.setUrl(urls);
        return response;
    }
}
