package com.towerpeng.leetcode.string;

/**
 * 注意边界值
 *
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 */
public class ReverseStr541 {

    public String reverseStr(String s, int k) {

        char[] charArray = s.toCharArray();
        for (int i = 0;i<charArray.length;i+=k*2){
            int start = i;
            //最后一次是否够长度再循环一次，够长就是start+k-1，不够就取最后
            int end = Math.min(charArray.length-1,start+k-1);
            while(start<end){
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }
}
