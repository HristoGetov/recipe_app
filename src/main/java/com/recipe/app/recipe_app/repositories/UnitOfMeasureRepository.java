package com.recipe.app.recipe_app.repositories;

import com.recipe.app.recipe_app.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {


    Optional<UnitOfMeasure> findByDescription(String description);
}
