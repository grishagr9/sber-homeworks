package org.example.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<T> source, T t) {
        return source.indexOf(t);
    }

    public static<T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static<T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static void removeAll(List removeFrom, List c2) {

    }

    public static boolean containsAll(List c1, List c2) {

    }

    public static boolean containsAny(List c1, List c2) {

    }

    public static List range(List list, Object min, Object max) {

    }

    public static List range(List list, Object min, Object max, Comparator comparator) {

    }
}
