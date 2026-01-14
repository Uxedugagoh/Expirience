package com.example.MPQtask1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class ProductOfArrayExceptSelfTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(new int[] {24, 12, 8, 6}, new int[] {1, 2, 3, 4}),
                Arguments.of(new int[] {0, 0, 9, 0, 0}, new int[] {-1, 1, 0, -3, 3}),
                Arguments.of(new int[] {0, 0, 0, 0, 0}, new int[] {-1, 0, 0, -3, 3})

        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int[] expected, int[] array) {
        assertThat(ProductOfArrayExceptSelf.secondProductExceptSelf(array))
                .isEqualTo(expected);
    }
}