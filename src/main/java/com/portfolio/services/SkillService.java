package com.portfolio.services;

import com.portfolio.models.Skill;
import com.portfolio.models.SkillPayload;
import com.portfolio.models.dto.SkillDto;
import com.portfolio.repositories.SkillRepository;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class SkillService {

    private final PhotoService _photoService;
    private final SkillRepository _skillRepo;

    public SkillService(PhotoService photoService, SkillRepository skillRepo) {
        _photoService = photoService;
        _skillRepo = skillRepo;
    }

    public List<Skill> getSkillList() {
        return (List<Skill>) _skillRepo.findAll();
    }

    public Skill addSkill(SkillPayload payload) throws IOException {
        var res = _photoService.addPhoto(payload.getImageFile());

        Skill skill = new Skill();
        skill.setName(payload.getName());
        skill.setPhoto(res);

        return _skillRepo.save(skill);
    }
}
