package com.example.task1;

import java.util.HashMap;

public class TwoSum {

    public static int[] worseTwoSum(int[] nums, int target) {
        // O(n^2) - time, O(1) - space
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no summs in array");
    }

    public static int[] twoSum(int[] nums, int target) {
        // O(n) - time, O(n) - space
        HashMap<Integer, Integer> map = new HashMap<>();
        int cur;
        int x;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            x = target - cur;
            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }
            map.put(cur, i);
        }
        throw new IllegalArgumentException("no summs in array");
        /*
        * В данном случае в качестве ключа мы используем именно значение самого массива, а не индекс.
        * Это не критично, так как при дубликате произойдёт перезапись индекса у одинакового значения
        * Проверка происходит перед перезаписью, так что это не страшно.
        * */
    }
}
