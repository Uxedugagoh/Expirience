package com.example.MPQtask2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int uBorder = 0;
        int lBorder = 0;
        int rBorder = matrix[0].length - 1;
        int dBorder = matrix.length - 1;
        boolean toUp = false;
        boolean toLeft = false;
        boolean horizontal = true;
        while (lBorder <= rBorder && uBorder <= dBorder) {
            if (horizontal) {
                if (!toLeft) {
                    for (int i = lBorder; i <= rBorder; i++) {
                        result.add(matrix[uBorder][i]);
                    }
                    uBorder += 1;
                    toLeft = true;
                } else {
                    for (int i = rBorder; i >= lBorder; i--) {
                        result.add(matrix[dBorder][i]);
                    }
                    dBorder -= 1;
                    toLeft = false;
                }
                horizontal = false;
            } else {
                if (!toUp) {
                    for (int i = uBorder; i <= dBorder; i++) {
                        result.add(matrix[i][rBorder]);
                    }
                    rBorder -= 1;
                    toUp = true;

                } else {
                    for (int i = dBorder; i >= uBorder; i--) {
                        result.add(matrix[i][lBorder]);
                    }
                    lBorder += 1;
                    toUp = false;
                }
                horizontal = true;
            }
        }
        return result;
    }
}