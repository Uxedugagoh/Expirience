package com.example.yaTask;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YaTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3), List.of(1, 1, 5, 7), List.of(5, 1, 7, 1)),
                Arguments.of(List.of(0, 0, 2, 4), List.of(1, 2, 3, 4), List.of(4, 3, 2, 1)),
                Arguments.of(List.of(1, 1, 1, 2), List.of(7, 1, 8, 4), List.of(7, 3, 7, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(List<Integer> expected, List<Integer> integerList1, List<Integer> integerList2) {
        int[] arr1 = listToArray(integerList1);
        int[] arr2 = listToArray(integerList2);
        int[] exp = listToArray(expected);
        int[] res = Ya.prefixes(arr1, arr2);
        assertThat(res).isEqualTo(exp);
    }

    public int[] listToArray(List<Integer> list) {
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}