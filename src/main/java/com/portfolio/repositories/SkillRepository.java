package com.portfolio.repositories;

import com.portfolio.models.Skill;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
}
