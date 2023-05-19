package com.portfolio.models.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillDto {
    private long id;
    private String name;
    private String logo;
}
