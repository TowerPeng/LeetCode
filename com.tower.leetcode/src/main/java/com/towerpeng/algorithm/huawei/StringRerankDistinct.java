package com.towerpeng.algorithm.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 题目描述
 * 排序规则：
 * 单词中字母比较不区分大小写，两个单词先以第一个字母作为排序的基准，如果第一个字母相同，就用第二个字母为基准，如果第二个字母相同就以第三个字母为基准。依此类推，如果到某个字母不相同，字母顺序在前的那个单词顺序在前。
 * 当一个短单词和一个长单词的开头部分都相同（即短单词是长单词从首字母开始的一部分），短单词顺序在前。
 * 字母大小写不同的相同单词，只输出一次。
 * 输入描述
 * 无
 * 输出描述
 * 无
 * 用例
 * 输入	Hello hello world
 * 输出	Hello world
 * 说明	无
 * 输入	i LOVE Cc I love CC Hello Hel Hellow
 * 输出	Cc Hel Hello Hellow i LOVE
 * 说明	无
 * @Author: 彭涛
 * @Date: 2026/2/28 11:38
 */
public class StringRerankDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        System.out.println(getResult(arr));
    }

    // 算法入口
    public static String getResult(String[] arr) {
        //按小写排序，然后入队去重
        Arrays.sort(arr, Comparator.comparing(String::toLowerCase));
        LinkedList<String> stack = new LinkedList<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            String s = arr[i];
            String top = stack.getLast().toLowerCase();
            String add = s.toLowerCase();
            //去重
            if (top.equals(add)) continue;
            stack.add(s);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (String s : stack) sj.add(s);
        return sj.toString();
    }

}


