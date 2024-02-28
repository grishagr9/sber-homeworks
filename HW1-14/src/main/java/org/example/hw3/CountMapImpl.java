package org.example.hw3;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{

    private Map<T, Integer> map;

    public CountMapImpl(){
        map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if(map.containsKey(o)){
            map.put(o, map.get(o)+1);
        }else{
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.get(o) == null? 0 : map.get(o);
    }

    @Override
    public int remove(T o) {
        int newValue = map.get(o) - 1;
        if(newValue==0){
            map.remove(o);
        }else{
            map.put(o, newValue);
        }
        return newValue + 1;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (var item:source.toMap().keySet()) {
            this.add(item);
        }
    }

    @Override
    public Map<T,Integer> toMap() {
        return this.map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
//        for (T item: this.map.keySet()) {
//            if(destination.containsKey(item)){
//                destination.put(item, destination.get(item)+1);
//            }else{
//                destination.put(item, 1);
//            }
//        }
        destination.putAll(this.map);
    }
}
