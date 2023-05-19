package com.portfolio.controller;

import com.portfolio.models.Skill;
import com.portfolio.models.dto.SkillDto;
import com.portfolio.services.SkillService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;

import java.util.List;

@Controller("api/v1/skill")
public class SkillController {
    private final SkillService _skillService;

    public SkillController(SkillService skillService) {
        _skillService = skillService;
    }

    @Get
    public HttpResponse<List<SkillDto>> getSkills() {
        return HttpResponse.ok(_skillService.getSkillList());
    }

    @Put
    public HttpResponse<SkillDto> AddSkill(@PathVariable Skill skill) {
        SkillDto  test = null;
        test.setId(1);
        test.setName("test");
        test.setLogo("link");
        
        return HttpResponse.ok(test);
    }
}
