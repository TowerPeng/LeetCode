package com.towerpeng.algorithm.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，
 * 并按照字母出现次数从大到小的顺序。输出各个字母及其出现次数。
 * 如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；
 * 字母和次数间用英文冒号分隔。
 * 用例
 * 输入	xyxyXX
 * 输出	x:2;y:2;X:2;
 * 说明	每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
 * 输入	abababb
 * 输出	b:4;a:3;
 * 说明	b的出现个数比a多，故b排在a之前
 * @Author: 彭涛
 * @Date: 2026/2/28 10:01
 */
public class StringRerankCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    public static String getResult(String s){
        HashMap<Character, Integer> letter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letter.put(c, letter.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        letter.entrySet().stream().sorted((a,b)->{
            if (a.getValue() - b.getValue() != 0) {
                return b.getValue() - a.getValue();
            } else {
                //相同的时候处理
                if ((isLower(a.getKey()) && isLower(b.getKey()))
                        || (isUpper(a.getKey()) && isUpper(b.getKey()))) {
                    return a.getKey() - b.getKey();
                } else {
                    if (isUpper(a.getKey())) return 1;
                    else return -1;
                }
            }
        }).forEach(entry -> sb.append(entry.getKey() + ":" + entry.getValue() + ";"));
        return sb.toString();
    }

    public static boolean isLower(char letter) {
        return letter >= 'a' && letter <= 'z';
    }

    public static boolean isUpper(char letter) {
        return letter >= 'A' && letter <= 'Z';
    }
}
