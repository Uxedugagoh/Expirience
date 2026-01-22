package com.example.Ttask1;

public class StringSort {
    public static String stringSort(String s) {
        // Преобразование в массив цифр
        byte[] array = new byte[s.length()];
        for (byte i = 0; i < s.length(); i++) {
            array[i] = Byte.parseByte(Character.toString(s.charAt(i)));
        }
        // Сортировка массива
        quickSort(array, 0, array.length - 1);

        // Перемена мест значащего 0 с ближайшим числом != 0
        // Проверка на случай, с числом, состоящим только из нулей.
        boolean allNulls = true;
        if(array[0] == 0 && array.length > 1) {
            byte temp;
            for (int i = 1; i < array.length; i++) {
                if (array[i] != 0) {
                    temp = array[i];
                    array[i] = array[0];
                    array[0] = temp;
                    allNulls = false;
                    break;
                }
            }
            if (allNulls) {
                return "0";
            }
        }
        // Сбор массива в строку
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : array) {
            stringBuilder.append(b);
        }
        return stringBuilder.toString();
    }

    public static void quickSort(byte[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(byte[] arr, int begin, int end) {
        byte pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                byte swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        byte swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
