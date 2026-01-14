package com.example.task21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MergeTwoSortedListsTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("[1, 1, 2, 3, 4, 4]", List.of(1, 2, 4), List.of(1, 3, 4)),
                Arguments.of("[]", List.of(), List.of()),
                Arguments.of("[0]", List.of(), List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String expected, List<Integer> list1, List<Integer> list2) {
        ListNode head1 = MergeTwoSortedLists.listToNode(list1);
        ListNode head2 = MergeTwoSortedLists.listToNode(list2);
        Assertions.assertEquals(expected,
                MergeTwoSortedLists.linkedListToArraylist(MergeTwoSortedLists.mergeTwoLists(head1, head2)).toString(),
                () -> String.format("Значения были: expected = %s, list1 = %s, list2 = %s", expected, list1, list2));
    }
}