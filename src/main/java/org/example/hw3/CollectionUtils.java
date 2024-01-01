package org.example.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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

    public static<T> void removeAll(List<T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return new HashSet<>(c1).containsAll(c2);
    }

    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        return c2.stream().filter(c1::contains).count() > 0;
    }

    public static<T> List<T> range(List<? extends T> list, T min, T max) {
        List<T> newList = new ArrayList<>();
        Comparator comp = new MyClassComparator<>();
        for (T item: list) {
            if(comp.compare(item, min)>=0 && comp.compare(item,max)<=0){
                newList.add(item);
            }
        }
        return newList;
    }

    public static<T> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        List<T> newList = new ArrayList<>();
        for (T item: list) {
            if(comparator.compare(item, min)>=0 && comparator.compare(item,max)<=0){
                newList.add(item);
            }
        }
        return newList;
    }

    static class MyClassComparator<T extends Comparable<T>> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }
}
