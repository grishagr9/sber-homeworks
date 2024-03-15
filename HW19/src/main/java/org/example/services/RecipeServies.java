package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entity.IngredientsEntity;
import org.example.entity.RecipeEntity;
import org.example.repositories.IngredientsRepository;
import org.example.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServies {

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;

    public void insert(String name){
        var recipe = new RecipeEntity();
        recipe.setName(name);
        recipeRepository.save(recipe);
        var ingredient = new IngredientsEntity();
        ingredient.setRecipe(recipe);
        ingredient.setQuantity(100);
        ingredient.setName(name);
        ingredientsRepository.save(ingredient);
    }
}
