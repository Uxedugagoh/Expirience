package com.example.task58;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal consisting of non-space characters only.

 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.

 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.

 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * */

public class LengthLastWord {
    public static int lengthOfLastWord(String s) {
        int res = 0;
        char[] chars;
        chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                for (int j = i; j >= 0; j--) {
                    if (chars[j] == ' ') {
                        return res;
                    }
                    res++;
                }
                return res;
            }
        }
        return res;
    }
}