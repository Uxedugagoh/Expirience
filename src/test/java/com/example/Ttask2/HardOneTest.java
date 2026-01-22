package com.example.Ttask2;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HardOneTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(0, "tbankstudy"),
                Arguments.of(5, "studtbankk"),
                Arguments.of(4, "tbankqwertyqwertyu"),
                Arguments.of(9, "qwefusqdgowqejhwei")
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, String input) {
        int res = HardOne.goodSubString(input);
        assertThat(res).isEqualTo(expected);
    }
}