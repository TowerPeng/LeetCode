package com.towerpeng.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LetterCombinations17 {

    List<String> list = new ArrayList<>();
    String[] numString = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        backTracking(digits, 0);
        return list;
    }

    //每次迭代获取一个字符串，所以会涉及大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //递归，处理下一层
            backTracking(digits, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
