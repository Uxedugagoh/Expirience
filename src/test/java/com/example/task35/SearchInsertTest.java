package com.example.task35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(2, 5, List.of(1, 3, 5, 6)),
                Arguments.of(1, 2, List.of(1, 3, 5, 6)),
                Arguments.of(4, 7, List.of(1, 3, 5, 6)),
                Arguments.of(2, 3, List.of(0, 2)),
                Arguments.of(1, 1, List.of(0, 2)),
                Arguments.of(0, 0, List.of(0, 2)),
                Arguments.of(1, 2, List.of(0)),
                Arguments.of(1, 2, List.of(1, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expected, int target, List<Integer> list) {
        int[] nums;
        nums = listToArray(list);
        int res = SearchInsert.searchInsert(nums, target);
        assertEquals(expected, res, () -> String.format("Значения были: " +
                "expected = %d, result = %d, target = %d, nums = %s", expected, res, target, Arrays.toString(nums)));
    }

    public int[] listToArray(List<Integer> list) {
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}