/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.app.recipe_app.services;

import com.recipe.app.recipe_app.comands.IngredienatCommand;
import com.recipe.app.recipe_app.comands.IngredientCommand;
import com.recipe.app.recipe_app.converters.IngredientToIngredientCommand;
import com.recipe.app.recipe_app.model.Recipe;
import com.recipe.app.recipe_app.repositories.RecipeRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author hristo
 */

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }
    
   
    
    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(!recipeOptional.isPresent()){
            System.out.println("Recipe not found. Id: " + recipeId);
        }
        Recipe recipe= recipeOptional.get();
        
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        
        if(!ingredientCommandOptional.isPresent()){
            System.out.println("Ingredient id not found! Id: " + ingredientId);
        }
        
        return ingredientCommandOptional.get();
     }
    
}
