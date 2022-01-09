/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.app.recipe_app.converters;

import com.recipe.app.recipe_app.comands.IngredientCommand;
import com.recipe.app.recipe_app.model.Ingredient;
import lombok.Synchronized;
import org.hibernate.annotations.Synchronize;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 *
 * @author hristo
 */

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient,IngredientCommand>{    

    private final UnitOfMeasureToUnitOfMeasureCommand uomCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomCommand) {
        this.uomCommand = uomCommand;
    }
    
    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null){
            return null;
        }
        
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUom(uomCommand.convert(source.getUom()));
        return ingredientCommand;
    }
}
