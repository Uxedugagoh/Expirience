package com.example.task14;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("av", List.of("aver", "avrg", "avsdf", "avbdf")),
                Arguments.of("fl", List.of("flower", "flow", "flight", "flamingo")),
                Arguments.of("", List.of("dog", "racecar", "car")),
                Arguments.of("", List.of("qwer", "avdf", "qwer", "qwer")),
                Arguments.of("dog", List.of("doggy", "dog", "dogoni", "dogitto")),
                Arguments.of("b", List.of("bavar", "barter", "boba", "blenf"))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String expected, List<String> s) {
        Assertions.assertEquals(expected, LongestCommonPrefix.longestCommonPrefix(listToArray(s)), () -> String.format("Значение было: s = %s, " +
                "expected = %s", s, expected));
    }

    private String[] listToArray(List<String> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}