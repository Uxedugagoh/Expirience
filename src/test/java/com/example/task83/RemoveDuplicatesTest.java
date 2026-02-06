package com.example.task83;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class RemoveDuplicatesTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(List.of(1, 2), List.of(1, 1, 2)),
                Arguments.of(List.of(1), List.of(1, 1)),
                Arguments.of(List.of(0), List.of(0, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 1, 2, 3, 3)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(0), List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(List<Integer> expected, List<Integer> list) {
        ListNode head = listToNode(list);
        head = RemoveDuplicates.deleteDuplicates(head);
        List<Integer> res = linkedListToArraylist(head);
        assertThat(res).isEqualTo(expected);
    }

    public static ListNode listToNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return new ListNode(list.get(0));
        }
        ListNode head = new ListNode(list.get(0));
        ListNode cur = new ListNode();
        head.next = cur;
        for (int i = 1; i < list.size(); i++) {
            cur.val = list.get(i);
            if (i == list.size() - 1) {
                break;
            }
            cur.next = new ListNode();
            cur = cur.next;
        }
        return head;
    }

    public static List<Integer> linkedListToArraylist(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}