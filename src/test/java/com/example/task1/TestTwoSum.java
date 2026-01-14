package com.example.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTwoSum {
    // Тесты не учитывают то, что могут быть значения в обратном порядке (0, 1) и (1, 0) - оба правильные
    // Потом переделаю когда-нибудь если захочу.
    @Test
    void testOne() {
        int[] arr = {2, 7, 11, 15};
        int[] exp = {0, 1};
        assertEquals(Arrays.toString(exp), Arrays.toString(TwoSum.twoSum(arr, 9)), "Значения были: " +
                "arr = {2, 7, 11, 15}, exp = {0, 1}, target = 9");
    }

    @Test
    void testTwo() {
        int[] arr = {3, 2, 4};
        int[] exp = {1, 2};
        assertEquals(Arrays.toString(exp), Arrays.toString(TwoSum.twoSum(arr, 6)), "Значения были: " +
                "arr = {2, 7, 11, 15}, exp = {1, 2}, target = 6");
    }

    @Test
    void testThree() {
        int[] arr = {3, 3};
        int[] exp = {0, 1};
        assertEquals(Arrays.toString(exp), Arrays.toString(TwoSum.twoSum(arr, 6)), "Значения были: " +
                "arr = {3, 3}, exp = {0, 1}, target = 6");
    }

}