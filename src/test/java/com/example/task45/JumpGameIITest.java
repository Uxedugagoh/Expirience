package com.example.task45;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameIITest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(3, List.of(3, 2, 1, 1, 10, 1)),
                Arguments.of(2, List.of(2, 3, 1, 1, 4)),
                Arguments.of(2, List.of(2, 3, 0, 1, 4)),
                Arguments.of(2, List.of(3, 10, 1, 1, 10, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, List<Integer> listDigits) {
        int[] digits = listToArray(listDigits);
        int res = JumpGameII.jump(digits);
        assertThat(res).isEqualTo(expected);
    }

    public int[] listToArray(List<Integer> list) {
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}