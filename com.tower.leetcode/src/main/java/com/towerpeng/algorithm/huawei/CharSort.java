package com.towerpeng.algorithm.huawei;

import java.util.Arrays;

/**
 * @Author: 彭涛
 * @Date: 2026/3/9 11:16
 */
public class CharSort {

    /**
     * 输入例子：
     * Ihave1nose2hands10fingers
     * 输出例子：
     * 0112Iaadeeefghhinnnorsssv
     */
    public static void main(String[] args) {
        String str = "Ihave1nose2hands10fingers";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.println(chars);
    }

    //写一个快速排序的算法入参int[]
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

}
