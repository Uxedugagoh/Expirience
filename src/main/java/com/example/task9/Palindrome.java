package com.example.task9;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        String pal = Integer.toString(x);
        char[] chars = pal.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[(chars.length - 1) - i]) {
                return false;
            }
        }
        return true;
    }
}