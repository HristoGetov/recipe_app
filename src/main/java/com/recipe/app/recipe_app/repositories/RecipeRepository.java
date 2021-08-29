package com.recipe.app.recipe_app.repositories;

import com.recipe.app.recipe_app.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
