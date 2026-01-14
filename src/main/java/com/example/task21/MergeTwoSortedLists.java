package com.example.task21;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode beforeHead = new ListNode();
        ListNode current = beforeHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;

        return beforeHead.next;
    }

    public static List<Integer> linkedListToArraylist(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
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
}