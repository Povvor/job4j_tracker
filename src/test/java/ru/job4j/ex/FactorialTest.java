package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void when4result24() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(4);
        int expected = 24;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void when0result1() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }
}