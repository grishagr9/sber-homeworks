package org.example.hw9;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private final Collection<T> collection;

    private Streams(Collection<T> collection){
        this.collection = collection;
    }

    public static<T> Streams<T> of(Collection<T> list) {
       return new Streams<T>(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        Collection<T> newCollection = new ArrayList<T>();
        for(T item: collection){
            if(predicate.test(item)){
                newCollection.add(item);
            }
        }
        return new Streams<T>(newCollection);
    }

    public Streams<T> transform(Function<? super T, ? extends T> mapper) {
        Collection<T> newCollection = new ArrayList<T>();
        for(T item: collection){
            newCollection.add(mapper.apply(item));
        }
        return new Streams<T>(newCollection);
    }

    public Map<T,T> toMap(Function<? super T, ? extends T> keys, Function<? super T, ? extends T> values) {

        return new HashMap();
    }

    public List<T> toList(){
        return collection.stream().toList();
    }
}
