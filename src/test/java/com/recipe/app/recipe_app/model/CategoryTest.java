package com.recipe.app.recipe_app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;
    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }

    @Test
    void getDescription() {
        String descriptionValue = "blabla";
        category.setDescription(descriptionValue);
        assertEquals(descriptionValue,category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}