package com.portfolio.repositories;

import com.portfolio.models.Photo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
