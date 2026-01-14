package com.example.task20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class ValidParenthesesTest {

    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(true, "()"),
                Arguments.of(true, "()[]{}"),
                Arguments.of(false, "(])"),
                Arguments.of(true, "([])"),
                Arguments.of(false, "([)]")

        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(boolean expected, String s) {
        Assertions.assertEquals(expected, ValidParentheses.isValid(s), () -> String.format("Значение было: " +
                "expected = %b s = \"%s\"", expected, s));
    }
}