package org.example;

import lombok.RequiredArgsConstructor;
import org.example.entity.IngredientsEntity;
import org.example.services.IngredientService;
import org.example.services.RecipeService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Worker {


    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Поиск рецепта");
            System.out.println("2. Добавление рецепта");
            System.out.println("3. Удаление рецепта");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchRecipe();
                    break;
                case 2:
                    addRecipe();
                    break;
                case 3:
                    deleteRecipe();
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private void deleteRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы удалить рецепт");
        String searchName = scanner.next();

        if(!recipeService.contain(searchName)){
            System.err.println("Данного рецепта не существует");
            return;
        }
        recipeService.delete(searchName);

        System.out.println("Данные успешно удалены!");
    }

    private void addRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы добавить рецепт");
        String recipeName = scanner.next();

        var recipe = recipeService.insert(recipeName);

        System.out.println("Введите количество элементов");
        int countIngr = scanner.nextInt();
        System.out.println("Вводите ингредиенты в формате НАЗВАНИЕ-КОЛИЧЕСТВО");
        for (int i = 0; i <countIngr; i++) {
            var line = scanner.next().split("-");
            if(line.length != 2){
                System.err.println("Ошибка ввода");
                return;
            }
            String name = line[0];
            Integer quantity = Integer.parseInt(line[1]);

            ingredientService.insert(recipe, name, quantity);
        }

        System.out.println("Данные успешно добавлены!");
    }

    private void searchRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы получить рецепт");
        String searchName = scanner.next();

        if(!recipeService.contain(searchName)){
            System.err.println("Данного рецепта не существует");
            return;
        }
        System.out.printf("Чтобы приготовить %s вам понадобится:%n", searchName);
        var recipe = recipeService.search(searchName);

        for (IngredientsEntity ingredient : recipe.getIngredientsEntityList()) {
            System.out.printf("%s в количестве %s%n", ingredient.getName(), ingredient.getQuantity());
        }

    }
}
