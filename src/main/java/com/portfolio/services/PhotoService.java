package com.portfolio.services;

import com.portfolio.models.Photo;
import com.portfolio.models.dto.UploadResultDto;
import com.portfolio.repositories.PhotoRepository;
import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.inject.Singleton;

import java.io.IOException;

@Singleton
public class PhotoService {
    private final CloudinaryService _cloudinaryService;
    private final PhotoRepository _photoRepo;

    public PhotoService(CloudinaryService cloudinaryService, PhotoRepository photoRepo) {
        _cloudinaryService = cloudinaryService;
        _photoRepo = photoRepo;
    }

    public Photo addPhoto(CompletedFileUpload file) throws IOException {
        UploadResultDto res = _cloudinaryService.uploadFile(file);
        if(res != null) {
            Photo photo = new Photo();
            photo.setDocPublicId(res.getPublicId());
            photo.setDocPublicId(res.getDocUrl());
            return _photoRepo.save(photo);
        }
        else  {
           throw new IOException("Failed to upload image");
        }
    }
}
