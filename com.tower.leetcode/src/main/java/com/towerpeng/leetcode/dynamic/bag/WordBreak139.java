package com.towerpeng.leetcode.dynamic.bag;

import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @Author: 彭涛
 * @Date: 2026/2/13 13:06
 */
public class WordBreak139 {

    //字符串能不能被字符串组成
    //完全背包问题
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp数组长度与s字符串长度一致
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];


    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
