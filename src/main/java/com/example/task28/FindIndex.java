package com.example.task28;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.

 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.

 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.

 */

public class FindIndex {
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        char[] charsHay;
        charsHay = haystack.toCharArray();
        char[] charsNee;
        charsNee = needle.toCharArray();
        int count = 1;
        int k;
        for (int i = 0; i < charsHay.length; i++) {
            if (charsHay[i] == charsNee[0]) {
                if (charsHay.length - i < charsNee.length) {
                    return -1;
                }
                k = i + 1;
                for (int j = 1; j < charsNee.length; j++) {
                    if (charsHay[k] != charsNee[j]) {
                        break;
                    }
                    count++;
                    k++;
                }
                if (count == charsNee.length) {
                    return i;
                } else {
                    count = 1;
                }
            }
        }
        return -1;
    }
}