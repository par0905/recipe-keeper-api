package com.recipeKeeper.RecipeBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private long id;
    private String name;
    private int cookTime;
    private String steps;
}
