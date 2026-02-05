package com.example.task70;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StairsTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(5, 4),
                Arguments.of(8, 5),
                Arguments.of(13, 6),
                Arguments.of(21, 7),
                Arguments.of(1134903170, 44)
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, int input) {
        int res = Stairs.climbStairs(input);
        assertThat(res).isEqualTo(expected);
    }
}