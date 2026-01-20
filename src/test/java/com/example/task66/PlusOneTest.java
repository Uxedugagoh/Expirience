package com.example.task66;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PlusOneTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 5, 7), List.of(1, 3, 5, 6)),
                Arguments.of(List.of(1, 2, 4), List.of(1, 2, 3)),
                Arguments.of(List.of(7), List.of(6)),
                Arguments.of(List.of(1, 0), List.of(9)),
                Arguments.of(List.of(2, 0), List.of(1, 9)),
                Arguments.of(List.of(1, 0, 0), List.of(9, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(List<Integer> expectedList, List<Integer> listDigits) {
        int[] expected = listToArray(expectedList);
        int[] digits = PlusOne.plusOne(listToArray(listDigits));
        assertThat(digits).isEqualTo(expected);
    }

    public int[] listToArray(List<Integer> list) {
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}