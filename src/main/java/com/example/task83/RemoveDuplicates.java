package com.example.task83;

public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int forbidden = prev.val;
        while (curr != null) {
            if (curr.val == forbidden) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            forbidden = curr.val;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}