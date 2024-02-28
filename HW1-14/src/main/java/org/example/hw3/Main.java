package org.example.hw3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("task1");
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
*/
        System.out.println("task2");
        List<Integer> list =  CollectionUtils.newArrayList();
        CollectionUtils.add(list, 1);
        CollectionUtils.add(list, 2);
        CollectionUtils.add(list, 3);
        CollectionUtils.add(list, 4);
        CollectionUtils.add(list, 5);
        System.out.println(list);

        List<Integer> list2 =  CollectionUtils.newArrayList();
        CollectionUtils.add(list2, 1);
        CollectionUtils.add(list2, 3);
        System.out.println(list2);

        System.out.println("index of 1: " + CollectionUtils.indexOf(list, 1));
        System.out.println("limit size 4: " + CollectionUtils.limit(list, 4));

        CollectionUtils.removeAll(list, list2);
        System.out.println("remove all from list elements of list2: " + list);

        CollectionUtils.addAll(list2, list);
        System.out.println("add all from list elements of list2: " + list);

        System.out.println("contains all? " + CollectionUtils.containsAll(list, list2));
        System.out.println("contains any? " + CollectionUtils.containsAny(list, list2));

        System.out.println("range 2..4: " + CollectionUtils.range(list, 2, 4));
    }
}
