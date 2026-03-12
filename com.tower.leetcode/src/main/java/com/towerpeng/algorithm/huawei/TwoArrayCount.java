package com.towerpeng.algorithm.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给定两个数组a，b，若a[i] == b[j] 则称 [i, j] 为一个二元组，求在给定的两个数组中，二元组的个数。
 * 输入描述
 * 第一行输入 m
 * 第二行输入m个数，表示第一个数组
 * 第三行输入 n
 * 第四行输入n个数，表示第二个数组
 * 输出描述
 * 二元组个数。
 * 用例
 * 输入	4
 * 1 2 3 4
 * 1
 * 1
 * 输出	1
 * 说明	二元组个数为 1个
 * 输入	6
 * 1 1 2 2 4 5
 * 3
 * 2 2 4
 * 输出	5
 * 说明	二元组个数为 5 个。
 *
 * @Author: 彭涛
 * @Date: 2026/2/28 14:11
 */
public class TwoArrayCount {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = Integer.parseInt(sc.nextLine());
        List<Integer> listM =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> listN =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(getResult(listM, listN));
    }

    private static int getResult(List<Integer> listM, List<Integer> listN) {
        //
        HashSet<Integer> setM = new HashSet<>(listM);
        HashSet<Integer> setN = new HashSet<>(listN);

        HashMap<Integer,Integer> countM = new HashMap<>();
        for(Integer i:listM){
            if(setM.contains(i)){
                countM.put(i,countM.getOrDefault(i,0)+1);
            }
        }
        HashMap<Integer,Integer> countN = new HashMap<>();
        for(Integer i:listN){
            if(setN.contains(i)){
                countN.put(i,countN.getOrDefault(i,0)+1);
            }
        }
        int count = 0;
        for(Integer i:countM.keySet()){
            count += countM.get(i) * countN.get(i);
        }
        return count;
    }

}
