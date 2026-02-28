package com.towerpeng.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 *
 * 变换规则：交换字符串中任意两个不同位置的字符。
 *
 * 输入描述
 * 一串小写字母组成的字符串s
 *
 * 输出描述
 * 按照要求进行变换得到的最小字符串。
 *
 * 备注
 * s是都是小写字符组成
 * 1 ≤ s.length ≤ 1000
 * 用例
 * 输入	abcdef
 * 输出	abcdef
 * 说明	abcdef已经是最小字符串，不需要交换。
 * 输入	bcdefa
 * 输出	acdefb
 * 说明	a和b进行位置交换，可以得到最小字符串
 *
 * @Author: 彭涛
 * @Date: 2026/2/28 13:11
 */
public class StringMinTransfer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }


    private static String getResult(String s) {
        //排序最低字符串
        char[] minSArr = s.toCharArray();
        Arrays.sort(minSArr);
        String minS = new String(minSArr);
        if(minS.equals( s)){
            return s;
        }
        char[] sArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != minS.charAt(i)){
                char temp = s.charAt(i);
                sArr[i] = minS.charAt(i);
                sArr[s.indexOf(minS.charAt(i))] = temp;
                break;
            }
        }
        return new String(sArr);
    }
}
