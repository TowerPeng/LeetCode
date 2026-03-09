package com.towerpeng.leetcode.dynamic.subList;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * @Author: 彭涛
 * @Date: 2026/2/27 13:24
 */
public class LongestPalindromeSubseq516 {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化，i和j相同的时候，初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    //转换为一个串和它的逆序串的最长公共子序列
    public int longestPalindromeSubseq1(String s) {
        return longestConsumeSubseq(s, new StringBuilder(s).reverse().toString());
    }

    public int longestConsumeSubseq(String t1,String t2){
        int n = t1.length();
        int m = t2.length();
        int same = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                same = (t1.charAt(i) == t2.charAt(j)?1:0);
                if(i==0 && j==0){
                    dp[i][j] = same;
                }else if(i==0){
                    if(same==1 || dp[i][j-1]==1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else if(j==0){
                    if(same==1 || dp[i-1][j]==1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else if(same==1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
