package com.example.task26;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(4, List.of(0, 1, 2, 3), List.of(0, 1, 2, 3)),
                Arguments.of(4, List.of(0, 1, 2, 3), List.of(0, 0, 0, 1, 1, 2, 3)),
                Arguments.of(3, List.of(0, 1, 2), List.of(0, 0, 0, 1, 2)),
                Arguments.of(2, List.of(0, 1), List.of(0, 1)),
                Arguments.of(1, List.of(0, 0, 0, 0), List.of(0, 0, 0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expectedK, List<Integer> expectedList, List<Integer> givenList) {
        int[] givenArr;
        givenArr = ListToArray(givenList);

        int resultK = RemoveDuplicates.removeDuplicates(givenArr);

        assertEquals(expectedK, resultK, () -> String.format("Значения были: " +
                "expected k = %d, k = %d", expectedK, resultK));
    }

    public int[] ListToArray(List<Integer> list) {
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}