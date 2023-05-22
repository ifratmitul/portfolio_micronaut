package com.portfolio.controller;

import com.portfolio.models.SkillPayload;
import com.portfolio.models.dto.SkillDto;
import com.portfolio.services.CloudinaryService;
import com.portfolio.services.SkillService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.multipart.StreamingFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller("api/v1/skill")
public class SkillController {
    private final SkillService _skillService;
    private final CloudinaryService _cloudinaryService;

    public SkillController(SkillService skillService, CloudinaryService cloudinaryService) {
        _skillService = skillService;
        _cloudinaryService = cloudinaryService;
    }

    @Get
    public HttpResponse<List<SkillDto>> getSkills() {
        return HttpResponse.ok(_skillService.getSkillList());
    }

    @Post(consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.TEXT_PLAIN)
    public HttpResponse<String> AddSkill(String name, CompletedFileUpload imageFile) throws IOException {
        System.out.println(name);
        var test = _cloudinaryService.uploadFile(imageFile);
        return HttpResponse.ok(test.toString());
    }

    @Post(value="/uploader",consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.TEXT_PLAIN)
    public HttpResponse<String> fileUploader(CompletedFileUpload file) throws IOException {
        try {
            String fileUrl = _cloudinaryService.uploadFile(file);
            return HttpResponse.ok(fileUrl);
        } catch (IOException e) {
            return HttpResponse.serverError(e.getMessage());
        }
    }
}
