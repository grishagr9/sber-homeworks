package org.example.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.IngredientsEntity;
import org.example.entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends CrudRepository<IngredientsEntity, Integer> {

    void deleteByRecipe(RecipeEntity recipe);
}
