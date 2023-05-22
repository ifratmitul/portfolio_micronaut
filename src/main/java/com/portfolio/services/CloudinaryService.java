package com.portfolio.services;

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

    public String uploadFile(CompletedFileUpload fileUpload) throws IOException {
        var fileBytes = fileUpload.getBytes();
        Map<String, Object> uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.emptyMap());
        return (String) uploadResult.toString();
    }

    public String uploadFile(File fileUpload) throws IOException {
        var test = fileUpload.getAbsolutePath();
        var test2 = fileUpload.getPath();
        var fileBytes = fileToByteArray(fileUpload);
        Map<String, Object> uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.emptyMap());
        return (String) uploadResult.toString();
    }

    public byte[] fileToByteArray(File file) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            long fileSize = file.length();
            if (fileSize > Integer.MAX_VALUE) {
                throw new IOException("File is too large to read into a byte array");
            }

            byte[] bytes = new byte[(int) fileSize];
            int offset = 0;
            int bytesRead;
            while (offset < bytes.length && (bytesRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += bytesRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Failed to read the entire file into a byte array");
            }

            return bytes;
        }
    }

}

