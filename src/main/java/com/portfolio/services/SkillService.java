package com.portfolio.services;

import com.portfolio.models.dto.SkillDto;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SkillService {

    public List<SkillDto> getSkillList() {
        List<SkillDto> skills = new ArrayList<>();
        return skills;
    }
}
