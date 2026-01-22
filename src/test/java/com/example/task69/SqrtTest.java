package com.example.task69;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SqrtTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(2, 4),
                Arguments.of(2, 8),
                Arguments.of(3, 9),
                Arguments.of(12, 147)
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, int input) {
        int res = Sqrt.mySqrt(input);
        assertThat(res).isEqualTo(expected);
    }
}