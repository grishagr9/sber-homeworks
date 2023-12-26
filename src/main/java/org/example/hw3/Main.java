package org.example.hw3;

public class Main {
    public static void main(String[] args) {
        System.out.println("task1");
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println("количество добавлений элемента 5 = " + map.getCount(5));  // 2
        System.out.println("количество добавлений элемента 6 = " + map.getCount(6));  // 1
        System.out.println("количество добавлений элемента 10 = " + map.getCount(10));  // 3

        System.out.println("количество добавлений элемента 5 до удаления = " + map.remove(5));
        System.out.println("количество добавлений элемента 5 до удаления = " + map.getCount(5));

        System.out.println("количество разных элементов = " + map.size());

        System.out.println("task2");
    }
}
