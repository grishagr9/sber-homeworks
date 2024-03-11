package org.example;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.jdbc.JDBCTemplateDemo;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final JDBCTemplateDemo jdbcTemplateDemo;

    //CREATE
    private static final String CREATE_RECIPES_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS recipes (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL)";
    private static final String CREATE_INGREDIENTS_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS ingredients (id SERIAL PRIMARY KEY, recipe_id INTEGER, name VARCHAR(255) NOT NULL, quantity INTEGER)";

    //READ
    private static final String READ_INGREDIENTS = "SELECT * FROM ingredients WHERE recipe_id = %d";

    //UPDATE
    private static final String INSERT_INGREDIENTS_SQL =
            "INSERT INTO ingredients (recipe_id, name, quantity) VALUES (%d, '%s', %d)";
    private static final String INSERT_RECIPES_SQL =
            "INSERT INTO recipes (name) VALUES ('%s')";

    //DELETE
    private static final String DELETE_INGREDIENTS_SQL =  "DELETE FROM ingredients WHERE recipe_id = %d";
    private static final String DELETE_RECIPES_SQL =  "DELETE FROM recipes WHERE name = '%s'";

    public void start(){
        Scanner scanner = new Scanner(System.in);
        jdbcTemplateDemo.createTable(CREATE_RECIPES_TABLE_SQL);
        jdbcTemplateDemo.createTable(CREATE_INGREDIENTS_TABLE_SQL);
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

    private void searchRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы получить рецепт");
        String searchName = scanner.next();

        var result = jdbcTemplateDemo.readTable(String.format("SELECT id FROM recipes WHERE name = '%s'", searchName));
        if(result.isEmpty()){
            System.err.println("Данного рецепта не существует");
            return;
        }
        Integer id = (Integer)result.get(0).get("id");
        var ingredients = jdbcTemplateDemo.readTable(String.format(READ_INGREDIENTS, id));

        System.out.println(String.format("Чтобы приготовить %s вам понадобится:", searchName));
        for (var item: ingredients) {
            System.out.println(String.format("%s в количестве %s", item.get("name"), item.get("quantity")));
        }

    }

    private void addRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы добавить рецепт");
        String recipeName = scanner.next();

        if(contains(recipeName)){
            System.err.println("Данный рецепт уже существует!");
            return;
        }
        jdbcTemplateDemo.insertTable(String.format(INSERT_RECIPES_SQL,recipeName));

        Integer id = (Integer) jdbcTemplateDemo.readTable(String.format("SELECT id FROM recipes WHERE name = '%s'", recipeName)).get(0).get("id");
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

            jdbcTemplateDemo.insertTable(String.format(INSERT_INGREDIENTS_SQL, id, name, quantity));
        }

        System.out.println("Данные успешно добавлены!");
    }

    private void deleteRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда, чтобы удалить рецепт");
        String searchName = scanner.next();

        var result = jdbcTemplateDemo.readTable(String.format("SELECT id FROM recipes WHERE name = '%s'", searchName));
        if(result.isEmpty()){
            System.err.println("Данного рецепта не существует");
            return;
        }
        Integer id =(Integer) result.get(0).get("id");
        jdbcTemplateDemo.deleteTable(String.format(DELETE_RECIPES_SQL, searchName));
        jdbcTemplateDemo.deleteTable(String.format(DELETE_INGREDIENTS_SQL, id));

        System.out.println("Данные успешно удалены!");
    }

    private boolean contains(String name){
        return !jdbcTemplateDemo.readTable(String.format("SELECT id FROM recipes WHERE name = '%s'", name)).isEmpty();
    }
}
