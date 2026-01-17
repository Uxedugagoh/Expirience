package com.example.task28;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindIndexTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("aboba", "aboba", 0),
                Arguments.of("bobalet", "bal", 2),
                Arguments.of("qwerty", "r", 3),
                Arguments.of("adg", "adgn", -1),
                Arguments.of("lorem", "ore", 1),
                Arguments.of("pi", "i", 1),
                Arguments.of("uxedugagoh", "goh", 7),
                Arguments.of("hellhgohell", "hel", 0),
                Arguments.of("mississippi", "issipi", -1),
                Arguments.of("mississippi", "sippia", -1)

        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String haystack, String needle, int expected) {
        int res = FindIndex.strStr(haystack, needle);
        assertEquals(expected, res, () -> String.format("Значения были: " +
                "expected = %d, k = %d\nhaystack = \"%s\", needle = \"%s\"", expected, res, haystack, needle));
    }
}