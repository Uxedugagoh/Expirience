package com.example.MPQtask2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpiralMatrixTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}),
                Arguments.of(List.of(1, 2, 3, 6, 5, 4), new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}}),
                Arguments.of(List.of(1, 2, 3, 4, 8, 12, 16, 20, 24, 23, 22, 21, 17, 13, 9, 5, 6, 7, 11, 15,
                        19, 18, 14, 10), new int[][]{
                        {1,  2,  3,  4},
                        {5,  6,  7,  8},
                        {9,  10, 11, 12},
                        {13, 14, 15, 16},
                        {17, 18, 19, 20},
                        {21, 22, 23, 24}}
                )

        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(List<Integer> expected, int[][] givenArray) {
        List<Integer> res = SpiralMatrix.spiralOrder(givenArray);
        System.out.println(res);
        assertThat(res)
                .isEqualTo(expected);
    }
}