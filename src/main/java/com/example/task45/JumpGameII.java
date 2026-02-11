package com.example.task45;

import java.util.Arrays;

public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] idea = new int[nums.length];
        Arrays.fill(idea, 10000);
        idea[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int jumpCap = nums[i];
            for (int j = i + 1; j <= i + jumpCap; j++) {
                if (j >= nums.length) {
                    break;
                }
                if (idea[j] == 10000) {
                    idea[j] = idea[i] + 1;
                }
            }
        }
        return idea[nums.length - 1];
    }
}