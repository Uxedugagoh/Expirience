package com.example.task58;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthLastWordTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of(" ", 0),
                Arguments.of("", 0),
                Arguments.of("a", 1),
                Arguments.of(" ad", 2),
                Arguments.of(" adi d ", 1),
                Arguments.of("pava pepa ima boy", 3),
                Arguments.of("hels     ", 4),
                Arguments.of("    scv     ", 3),
                Arguments.of("whoR", 4)

        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String s, int expected) {
        int res = LengthLastWord.lengthOfLastWord(s);
        assertEquals(expected, res, () -> String.format("Значения были: " +
                "expected = %d, k = %d", expected, res));
    }
}