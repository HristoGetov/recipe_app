/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.app.recipe_app.comands;

import java.math.BigDecimal;
import lombok.*;

/**
 *
 * @author hristo
 */

@Getter
@Setter
@NoArgsConstructor
public class IngredienatCommand {
    
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
    
}
