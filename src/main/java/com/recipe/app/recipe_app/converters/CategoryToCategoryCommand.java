/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.app.recipe_app.converters;

import com.recipe.app.recipe_app.comands.CategoryCommand;
import com.recipe.app.recipe_app.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author hristo
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category,CategoryCommand>{

    @Override
    public CategoryCommand convert(Category source) {
        if(source == null){
            return null;
        }
        
        final CategoryCommand categoryCommand = new CategoryCommand();
        
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        
        return categoryCommand;
    }
    
}
