package org.example.hw6;

import lombok.AllArgsConstructor;

public class MyArrayIterator<T> {

    private int index;
    private int size;
    private T[] array;

    public MyArrayIterator(T[] arr){
        this.array = arr;
        index = 0;
        size = arr.length;
    }

    public Boolean hasNext(){
        return index < size && array[index]!=null;
    }

    public void remove(){
        throw new UnsupportedOperationException("remove");
    }

    T next(){
        return array[index++];
    }


}
