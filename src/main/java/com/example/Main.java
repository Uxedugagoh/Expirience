package com.example;

import com.example.MPQtask3.MergeKLists;
import com.example.task21.ListNode;
import com.example.task21.MergeTwoSortedLists;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ListNode breforeHead = new ListNode();
        ListNode current = breforeHead;
        ListNode breforeHead2 = new ListNode();
        ListNode current2 = breforeHead2;
        ListNode breforeHead3 = new ListNode();
        ListNode current3 = breforeHead3;
        ListNode breforeHead4 = new ListNode();
        ListNode current4 = breforeHead4;
        ListNode breforeHead5 = new ListNode();
        ListNode current5 = breforeHead5;
        for (int i = 0; i < 5; i++) {
            current.next = new ListNode(i * 2);
            current = current.next;
            current2.next = new ListNode(i * 2);
            current2 = current2.next;
            current3.next = new ListNode(i * 2);
            current3 = current3.next;
            current4.next = new ListNode(i * 2);
            current4 = current4.next;
            current5.next = new ListNode(i * 2);
            current5 = current5.next;
        }
        ListNode[] arr = {breforeHead.next, breforeHead2.next, breforeHead3.next, breforeHead4.next, breforeHead5.next};
        System.out.println(Arrays.stream(arr));
        MergeKLists.mergeKLists(arr);
    }
}