package org.example.hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

class MyArrayIteratorTest {

    @Test
    void hasNext_notHasNext() {
        MyArrayIterator<Integer> iterator = new MyArrayIterator<>(new Integer[0]);
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void hasNext_hasNextNullElem() {
        MyArrayIterator<Integer> iterator = new MyArrayIterator<>(new Integer[1]);
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void hasNext_hasNextElem() {
        MyArrayIterator<Integer> iterator = new MyArrayIterator<>(new Integer[]{1});
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    void remove_throwException() {
        MyArrayIterator<Integer> iterator = new MyArrayIterator<>(new Integer[]{1});
        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    void next() {
        MyArrayIterator<Integer> iterator = new MyArrayIterator<>(new Integer[]{1,2});
        Assertions.assertEquals(1, iterator.next());
        Assertions.assertEquals(2, iterator.next());
    }
}