package com.recipe.app.recipe_app.comands;

import java.math.BigDecimal;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}
