package com.recipeKeeper.RecipeBackend.controller;

import com.recipeKeeper.RecipeBackend.model.Recipe;
import com.recipeKeeper.RecipeBackend.service.RecipeService;
import com.recipeKeeper.RecipeBackend.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class RecipeController {
    private final RecipeService recipeService;
    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipes")
    public Recipe createRecipes(@RequestBody Recipe recipe){
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/recipes")
    public List<Recipe> getTopRecipes(){
        return recipeService.getTopRecipes();
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = recipeService.deleteRecipe(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = null;
        recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id,
                                                   @RequestBody Recipe recipe) {
        recipe = recipeService.updateRecipe(id, recipe);
        return ResponseEntity.ok(recipe);
    }
}
