package com.intercafe.admin.controller;
import com.intercafe.admin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/storeImage")
    private void storeImage(@RequestParam("foodImages") MultipartFile... foodImages) throws IOException {

        String uploadDirectory = "src/main/resources/images/foodImages";
        StringBuilder fdImageString = new StringBuilder();

        for (MultipartFile imageFile : foodImages) {
            fdImageString.append(imageService.saveImageToStorage(uploadDirectory, imageFile)).append(",");
        }
    }

    @GetMapping("/names/{imageId}")
    public ResponseEntity<List<String>> getImageNames(@PathVariable Long imageId) {
        List<String> imageNames = imageService.getImageNamesByImageId(imageId);
        return ResponseEntity.ok(imageNames);
    }
}
