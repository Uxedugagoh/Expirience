package com.example.MPQtask1;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */

public class ProductOfArrayExceptSelf {
    public static int[] secondProductExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                temp *= nums[j];
            }
            answer[i] = temp;
            temp = 1;
        }
        return answer;
    }

    public static int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum *= nums[i];
            } else {
                zeros++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 1) {
                nums[i] = 0;
                continue;
            }
            if (zeros == 1) {
                if (nums[i] == 0) {
                    nums[i] = sum;
                    continue;
                }
                nums[i] = 0;
                continue;
            }
            nums[i] = sum / nums[i];
        }
        return nums;
    }
}