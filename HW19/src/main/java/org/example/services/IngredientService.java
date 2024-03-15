package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entity.IngredientsEntity;
import org.example.repositories.IngredientsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientsRepository repository;

    public void insert(String name, Integer quantity){
        IngredientsEntity ingredients = new IngredientsEntity();
        ingredients.setQuantity(quantity);
        ingredients.setName(name);
        repository.save(ingredients);
    }
}
