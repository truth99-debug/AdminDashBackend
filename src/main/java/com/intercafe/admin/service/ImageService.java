package com.intercafe.admin.service;

import com.intercafe.admin.model.ImageData;
import com.intercafe.admin.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Service
public class ImageService {



    //save image in a local directory
    public String saveImageToStorage(String uploadDirectory, MultipartFile imageFile) throws IOException {
        String uniqueFileName = imageFile.getOriginalFilename();

        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

    // To view an image
    public static byte[] getFoodImages(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return imageBytes;
        } else {
            return null; // Handle missing images
        }
    }

    // Delete an image
    public String deleteImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return "Success";
        } else {
            return "Failed"; // Handle missing images
        }
    }

    @Autowired
    private ImageRepository imageRepository;

    public void processImage(MultipartFile file) throws IOException {
        ImageData imageData = new ImageData();

//        imageData.setImageFile(file.getBytes());
        imageRepository.save(imageData);

    }

    public List<String> getImageNamesByImageId(Long imageId) {
        return imageRepository.findImageNamesByImageId(imageId);
    }
}

