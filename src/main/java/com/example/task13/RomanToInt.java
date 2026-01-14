package com.example.task13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static int romanToInt(String s) {
        int sum = 0, num = 0;
        // Логика римских цифр такая:
        // Если меньшее число стоит перед большим (IV или IX) - Оно вычитается, иначе (VI или XI) - прибавляется
        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            // Умножение на 3 происходит для того, чтобы, наприемер, цифра III на 3й итерации цикла не вычла
            // num = 1 - текущую цифру из накопившейся суммы sum = 2, ведь по условию num < sum
            // Поэтому num * 3 < sum
            if (3 * num < sum)
                sum -= num;
            else
                sum += num;
        }
        return sum;
    }
}