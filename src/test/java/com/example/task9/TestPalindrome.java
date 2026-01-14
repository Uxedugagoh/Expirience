package com.example.task9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestPalindrome {

    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(1551, true),
                Arguments.of(123673, false),
                Arguments.of(7456547, true),
                Arguments.of(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void isPalindrome(int x, boolean expected) {
        Assertions.assertEquals(expected, Palindrome.isPalindrome(x), () -> String.format("Входные значения: %d, %b", x, expected));
    }
}