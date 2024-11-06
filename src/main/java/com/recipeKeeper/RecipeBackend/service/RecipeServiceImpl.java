package com.recipeKeeper.RecipeBackend.service;

import com.recipeKeeper.RecipeBackend.entity.RecipeEntity;
import com.recipeKeeper.RecipeBackend.model.Recipe;
import com.recipeKeeper.RecipeBackend.repository.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService{
    private RecipeRepository recipeRepository;
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe createRecipe(Recipe recipe){
        RecipeEntity recipeEntity = new RecipeEntity();
        BeanUtils.copyProperties(recipe, recipeEntity);
        recipeRepository.save(recipeEntity);
        return  recipe;
    }

//    @Override
//    public List<Recipe> getTopRecipes(int num){
//        List<RecipeEntity> e = recipeRepository.findAll();
//        List<Recipe> r = new ArrayList<Recipe>();
//        for(int i=0; i<=num; i++){
////            System.out.println(e.get(i));
//            Recipe recipe = new Recipe();
//            BeanUtils.copyProperties(e.get(i), recipe);
//            r.add(recipe);
//        }
//        return r;
//    }

    @Override
    public List<Recipe> getTopRecipes() {
        List<RecipeEntity> recipeEntities
                = recipeRepository.findAll();

        List<Recipe> recipes = recipeEntities
                .stream()
                .map(rec -> new Recipe(
                        rec.getId(),
                        rec.getName(),
                        rec.getCookTime(),
                        rec.getSteps()))
                .collect(Collectors.toList());
        return recipes;
    }

    @Override
    public boolean deleteRecipe(Long id) {
        RecipeEntity recipe = recipeRepository.findById(id).get();
        recipeRepository.delete(recipe);
        return true;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        RecipeEntity recipeEntity
                = recipeRepository.findById(id).get();
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(recipeEntity, recipe);
        return recipe;
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        RecipeEntity recipeEntity
                = recipeRepository.findById(id).get();
        recipeEntity.setName(recipe.getName());
        recipeEntity.setCookTime(recipe.getCookTime());
        recipeEntity.setSteps(recipe.getSteps());

        recipeRepository.save(recipeEntity);
        return recipe;
    }
}
