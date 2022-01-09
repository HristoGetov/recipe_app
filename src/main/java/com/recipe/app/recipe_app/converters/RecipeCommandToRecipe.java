/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.app.recipe_app.converters;

import com.recipe.app.recipe_app.converters.NotesCommandToNotes;
import com.recipe.app.recipe_app.converters.IngredientCommandToIngrediaent;
import com.recipe.app.recipe_app.converters.CategoryCommandToCategory;
import com.recipe.app.recipe_app.comands.RecipeCommand;
import com.recipe.app.recipe_app.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 *
 * @author hristo
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>{

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngrediaent ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngrediaent ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }
    
    
    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null){
            return null;
        }
        
        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setNotes(notesConverter.convert(source.getNotes()));
        
        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories().forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }
        
        if(source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        
        return recipe;
    }
    
}
