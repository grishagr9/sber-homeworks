package org.example.hw5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static final String MONDAY = "MONDAY";
    public static final String VTORNIK = "MONDAY";

    static void task1(){
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(4));
    }

    static void task2(){
        Student s = new Student();
        Person p = new Person();

        Class<?> clazz = s.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Методы класса:");
        for (Method method: methods) {
            System.out.println(method.getName());
        }
        System.out.println("Методы родительских классов");
        while (true) {
            clazz = clazz.getSuperclass();
            if(clazz == null){
                break;
            }
            System.out.printf("Class %s%n", clazz.getSimpleName());
            Method[] methodsParent = clazz.getDeclaredMethods();
            for (Method method : methodsParent) {
                System.out.println(method.getName());
            }
        }
    }

    static void task3(){
        Person person = new Person();
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method: methods) {
            if(method.getName().startsWith("get") || method.getName().startsWith("is")){
                System.out.println(method.getName());
            }
        }
    }

    static void questionsTask(){
        System.out.println("1. Почему на любом объекте можем вызвать метод getClass()?");
        System.err.println("1. Метод getClass() является одним из методов класса Object, от которого наследуются все классы " +
                "в Java. Поэтому этот метод может быть вызван на любом объекте, так как все объекты являются экземплярами" +
                " какого-либо класса.");
        System.out.println("2. Почему на любом классе можем вызвать .class?");
        System.err.println("2. На любом классе мы можем вызвать метод .class, потому что в Java каждый класс является объектом" +
                " типа java.lang.Class. Метод .class возвращает объект типа Class, представляющий данный класс");
        System.out.println("3. В чём отличие динамического прокси от статического?\n" +
                "Приведите преимущества и недостатки.");
        System.err.println("3. Статическое прокси - это прокси-сервер, предназначенный для обработки заранее определенных типов запросов.\n" +
                "Динамическое прокси - это прокси-сервер, который создается и настраивается во время работы системы.\n" +
                "Преимущества динамического прокси Гибкость и адаптивность: Динамический прокси может адаптироваться к изменяющимся условиям\n" +
                " и требованиям, что делает его гибким в использовании.\n" +
                "Недостатки динамического прокси:\n" +
                "Высокая нагрузка на систему: \n" +
                "Использование динамического прокси может привести к увеличению нагрузки на систему, так как прокси может\n" +
                " требовать дополнительных ресурсов для обработки и фильтрации запросов.");
    }

    static void task4(){
        System.out.println(MONDAY);
        System.out.println(VTORNIK);

        Class<?> clazz = Main.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            try {
                if(Modifier.isFinal(field.getModifiers())){
                    String value = (String) field.get(null);
                    String name = field.getName();

                    if(!value.equals(name)){
                        System.out.printf("Ошибка именования константы, значение %s не соответствует имени %s\n", value, name);
                    }
                }
            }catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    static void task7(){
        Customer person = new Customer("John", 25);
        User user = new User();

        BeanUtils.assign(user, person);

        System.out.println(user.getName()); // Выведет "John"
        System.out.println(user.getAge());  // Выведет 25
    }
    public static void main(String[] args) {
        //questionsTask();
        //task1();
        //task2();
        //task3();
        //task4();
        task7();
    }

    static class Customer {
        private String name;
        private int age;

        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    static class User {
        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
