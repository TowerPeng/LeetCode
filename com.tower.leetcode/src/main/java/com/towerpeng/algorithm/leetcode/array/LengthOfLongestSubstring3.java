package com.towerpeng.algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();  // 用于存储当前窗口中的字符
        int n = s.length();                              // 字符串长度
        int right = -1;                                  // 右指针，初始为-1（表示窗口左边界左侧）
        int result = 0;                                  // 记录最长子串长度

        for (int i = 0; i < n; i++) {                    // 左指针i，从0开始遍历每个可能的左边界
            if (i != 0) {
                occ.remove(s.charAt(i - 1));             // 当左指针向右移动时，移除窗口左侧的字符
            }

            // 右指针尽可能向右扩展，直到遇到重复字符或越界
            while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
                occ.add(s.charAt(right + 1));            // 将新字符加入窗口
                right++;                                 // 右指针右移
            }

            // 此时窗口 [i, right] 内的字符都不重复，更新最大长度
            result = Math.max(result, right - i + 1);
        }
        return result;
    }

}
