package org.example.hw5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {

    @SneakyThrows
    @Test
    void calc() {
        Calculator calculator = new CalculatorImpl();
        Assertions.assertEquals(120, calculator.calc(5));
    }
}