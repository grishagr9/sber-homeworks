package org.example;

import org.example.services.IngredientService;
import org.example.services.RecipeServies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var factory = SpringApplication.run(Main.class);
        var recipeService = factory.getBean(RecipeServies.class);
        var ingreidientsService = factory.getBean(IngredientService.class);

        recipeService.insert("XAXAXA");

    }
}