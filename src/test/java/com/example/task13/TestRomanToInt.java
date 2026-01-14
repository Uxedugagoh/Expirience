package com.example.task13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestRomanToInt {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(2563, "MMDLXIII"),
                Arguments.of(123, "CXXIII"),
                Arguments.of(3652, "MMMDCLII"),
                Arguments.of(11, "XI"),
                Arguments.of(9, "IX"),
                Arguments.of(1, "I")
        );
    }

    @Test
    void testOne() {
        String s = "MCMXCIV";
        assertEquals(1994, RomanToInt.romanToInt(s), "Значение было: s = \"MCMXCIV\"");
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, String s) {
        Assertions.assertEquals(expected, RomanToInt.romanToInt(s), () -> String.format("Значение было: s = %s, " +
                "expected = %d", s, expected));
    }
}