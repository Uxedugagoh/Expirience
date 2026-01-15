package com.example.task27;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Здесь я добавляю комментарий, после того как поменял мейл пользователя и у меня теперь должны
 * отображаться коммиты в истории гита
 * А это ещё один коммент, на проверку гита
 * */


class RemoveElementTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(3, List.of(0, 1, 2, 3)),
                Arguments.of(4, List.of(0, 0, 0, 1, 1, 2, 3)),
                Arguments.of(2, List.of(0, 0, 0, 1, 2)),
                Arguments.of(1, List.of(0, 1)),
                Arguments.of(0, List.of(0, 0, 0, 0)),
                Arguments.of(2, List.of(1, 2, 0, 0)),
                Arguments.of(3, List.of(0, 0, 0, 0, 1, 3, 0, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(int expectedK, List<Integer> givenList) {
        int[] givenArr;
        givenArr = ListToArray(givenList);

        int resultK = RemoveElement.removeElement(givenArr, 0);

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