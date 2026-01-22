package com.example.task69;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.

 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * */

public class Sqrt {
    // Используем бинарный поиск по числам от 1 до X.

    public static int mySqrt(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Используем "mid <= x / mid" вместо "mid * mid <= x" для защиты от переполнения значения int.
            // Знак <= как раз будет подходить под условие ближайшего числа округлённого вниз
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}