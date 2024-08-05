package com.intercafe.admin.repository;

import com.intercafe.admin.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageData, Long> {
    @Query("SELECT i.imageName FROM ImageData i WHERE i.id = :imageId")
    List<String> findImageNamesByImageId(@Param("imageId") Long imageId);
}
