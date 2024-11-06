package com.recipeKeeper.RecipeBackend.service;

import com.recipeKeeper.RecipeBackend.model.Recipe;

import java.util.List;

public interface RecipeService {
      Recipe createRecipe(Recipe recipe);

      List<Recipe> getTopRecipes();

      boolean deleteRecipe(Long id);

      Recipe getRecipeById(Long id);

      Recipe updateRecipe(Long id, Recipe recipe);
}
