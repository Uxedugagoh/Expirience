package com.example.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class AddTwoNumbersTest {

    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(List.of(8, 1, 3, 6), List.of(5, 1, 3, 7, 3, 6), List.of(3, 3, 6, 3, 4, 6)),
                Arguments.of(List.of(2, 4, 3), List.of(5, 6, 4), List.of(7, 0, 8)),
                Arguments.of(List.of(0), List.of(0), List.of(0)),
                Arguments.of(List.of(9, 9, 9, 9, 9, 9, 9), List.of(9, 9, 9, 9), List.of(8, 9, 9, 9, 0, 0, 0, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testAddTwoNumbers(List<Integer> l1, List<Integer> l2, List<Integer> expected) {
        AddTwoNumbers obj = new AddTwoNumbers();

        ListNode n1 = createNodeFromList(l1);
        ListNode n2 = createNodeFromList(l2);
        ListNode result = obj.addTwoNumbers(n1, n2);

        Assertions.assertThat(createArrayFromNode(result)).isEqualTo(expected);
    }

    private ListNode createNodeFromList(List<Integer> l1) {
        ListNode node = new ListNode();
        ListNode head = node;
        for (Integer i : l1) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    private ArrayList<Integer> createArrayFromNode(ListNode head) {
        ListNode current = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (current != null) {
            arrayList.add(current.val);
            current = current.next;
        }
        return arrayList;
    }
}