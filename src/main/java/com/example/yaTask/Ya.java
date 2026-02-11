package com.example.yaTask;

import java.util.HashSet;

public class Ya {
    /**
     * Для двух массивов целых чисел длины n, для всех k от 1 до n - посчитать кол-во общих числе на их префиксах длины k.
     * ex: Массив 1: [1, 1, 5, 7];
     *     Массив 2: [5, 1, 7, 1];
     * res: [0, 1, 2, 3]
     * */

    public static int[] prefixes(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            hashSet1.add(nums1[i]);
            hashSet2.add(nums2[i]);
            HashSet<Integer> disj = new HashSet<>(hashSet1);
            disj.retainAll(hashSet2);
            res[i] = disj.size();
        }
        return res;
    }
}
