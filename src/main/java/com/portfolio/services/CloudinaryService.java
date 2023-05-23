package com.portfolio.services;

import com.portfolio.models.dto.UploadResultDto;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import jakarta.inject.Singleton;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.*;
import java.util.Map;
@Singleton
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(@Value("${cloudinary.cloudName}") String cloudName,
                             @Value("${cloudinary.apiKey}") String apiKey,
                             @Value("${cloudinary.apiSecret}") String apiSecret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public UploadResultDto uploadFile(CompletedFileUpload fileUpload) throws IOException {
        var fileBytes = fileUpload.getBytes();
        Map<String, Object> uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.emptyMap());
        UploadResultDto res = new UploadResultDto((String)uploadResult.get("asset_id"), (String)uploadResult.get("secure_url"));
        return res;
    }
}

