package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entity.IngredientsEntity;
import org.example.entity.RecipeEntity;
import org.example.repositories.IngredientsRepository;
import org.example.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;

    public RecipeEntity insert(String recipeName){
        var recipe = new RecipeEntity();
        recipe.setName(recipeName);
        recipeRepository.save(recipe);

        return recipe;
    }

    public void delete(String recipeName){
        var recipe = recipeRepository.findByName(recipeName);

        recipeRepository.delete(recipe);
    }

    public boolean contain(String recipeName){
        return recipeRepository.findByName(recipeName) != null;
    }

    public RecipeEntity search(String recipeName){
        return recipeRepository.findByName(recipeName);
    }
}
