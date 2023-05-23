package com.portfolio.controller;

import com.portfolio.models.Skill;
import com.portfolio.models.SkillPayload;
import com.portfolio.services.SkillService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.IOException;
import java.util.List;

@Controller("api/v1/skill")
public class SkillController {
    private final SkillService _skillService;

    public SkillController(SkillService skillService) {
        _skillService = skillService;
    }

    @Get
    public HttpResponse<List<Skill>> getSkills() {
        return HttpResponse.ok(_skillService.getSkillList());
    }

    @Post(consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Skill> AddSkill(String name, CompletedFileUpload imageFile) throws IOException {
        SkillPayload payload = new SkillPayload(name, imageFile);
        return HttpResponse.ok(_skillService.addSkill(payload));
    }
}
