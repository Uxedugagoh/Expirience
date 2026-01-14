package com.example.task14;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Смысл в том, что префикс ищется среди всех значений сразу, а не самый популярный впринципе.
 * Поэтому для решения сначала сортируем массив строк в алфавитном порядке, и начинаем сравнивать
 * первый и последний элементы. Таким образом мы найдём longestCommonPrefix
 */


public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder target = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return target.toString();
            }
            target.append(first.charAt(i));
        }
        return target.toString();
    }
}