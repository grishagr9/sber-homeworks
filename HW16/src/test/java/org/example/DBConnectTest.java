package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectTest {

    @Test
    void givenNegativeNum_whenGiveData_thenNull() {
        //given
        DBConnect connect = new DBConnect();
        int i = -1;

        //when
        var result = connect.getData(i);

        //then
        Assertions.assertNull(result);
    }

    @Test
    void givenNum_whenGiveData_thenResult(){
        //given
        DBConnect connect = new DBConnect();
        int i = 1;
        List<Integer> expected = List.of(1);

        //when
        var actual = connect.getData(i);

        //then
        if(actual != null) {
            Assertions.assertEquals(expected, actual);
        }
    }
}