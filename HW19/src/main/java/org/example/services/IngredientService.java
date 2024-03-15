package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entity.IngredientsEntity;
import org.example.entity.RecipeEntity;
import org.example.repositories.IngredientsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientsRepository repository;

    public void insert(RecipeEntity recipe, String name, Integer quantity){
        var ingredient = new IngredientsEntity();
        ingredient.setRecipe(recipe);
        ingredient.setName(name);
        ingredient.setQuantity(quantity);

        repository.save(ingredient);
    }
}
