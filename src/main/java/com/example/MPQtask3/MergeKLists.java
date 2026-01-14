package com.example.MPQtask3;
import com.example.task21.ListNode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 */

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1 && lists[0] == null) return null;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                //treeMap.put(current.val, );
                current = current.next;
            }
        }
        return new ListNode();
    }
}