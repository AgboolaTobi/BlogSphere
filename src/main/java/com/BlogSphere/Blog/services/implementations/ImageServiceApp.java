package com.BlogSphere.Blog.services.implementations;

import com.BlogSphere.Blog.data.models.Image;
import com.BlogSphere.Blog.data.repositories.ImageRepository;
import com.BlogSphere.Blog.dtos.responses.UploadImageResponse;
import com.BlogSphere.Blog.services.interfaces.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ImageServiceApp implements ImageService {
    private final ImageRepository imageRepository;


    @Override
    public List<Image> saveImage(UploadImageResponse response) {
        Image image = new Image();
        List<Image> images = new ArrayList<>();
        for (String url : response.getUrl()){
            image.setImageUrl(url);
            imageRepository.save(image);
        }
        images.add(image);
        return images;
    }
}
