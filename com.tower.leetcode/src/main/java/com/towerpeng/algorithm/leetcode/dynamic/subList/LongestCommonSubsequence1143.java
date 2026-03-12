package com.towerpeng.algorithm.leetcode.dynamic.subList;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * @Author: 彭涛
 * @Date: 2026/2/24 10:44
 */
public class LongestCommonSubsequence1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= char1.length ; i++) {
            char charA = text1.charAt(i - 1);
            for (int j = 1; j <= char2.length; j++) {
                char charB = text2.charAt(j - 1);
                if (charA == charB) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        // char[] char1 = text1.toCharArray();
        // char[] char2 = text2.toCharArray();
        // 可以在一開始的時候就先把text1, text2 轉成char[]，之後就不需要有這麼多爲了處理字串的調整
        // 就可以和卡哥的code更一致

        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        // 获取两个字符串的长度
        int n = text1.length(), m = text2.length();
        // 将字符串转为字符数组，方便索引
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        // 创建dp二维数组，大小为 (n+1) x (m+1)，但实际只使用前n行和前m列
        // dp[i][j] 表示 text1[0..i] 和 text2[0..j] 的最长公共子序列长度
        int [][]dp = new int[n+1][m+1];
        // 外层循环遍历 text1 的每个字符
        for(int i =0;i<n;i++){
            // 内层循环遍历 text2 的每个字符
            for(int j = 0;j<m;j++){
                // 判断当前两个字符是否相等，相等则 same=1，否则 0
                int same = (char1[i] == char2[j]?1:0);
                // 处理左上角第一个元素 (0,0)
                if(i==0 && j==0){
                    dp[i][j] = same;  // 如果第一个字符相等则为1，否则0
                }
                // 处理第一行（i=0, j>0）：text1只有一个字符
                else if(i==0){
                    // 如果当前字符相等，或者前面已经出现过相等（即 dp[i][j-1]==1），则此位置为1
                    if(same==1 || dp[i][j-1]==1){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                // 处理第一列（j=0, i>0）：text2只有一个字符
                else if(j==0){
                    // 如果当前字符相等，或者上面已经出现过相等（即 dp[i-1][j]==1），则此位置为1
                    if(same==1 || dp[i-1][j]==1){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                // 当 i>0 且 j>0 且当前字符相等时，LCS长度等于左上角值加1
                else if(same== 1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 当 i>0 且 j>0 且当前字符不相等时，取左边和上边的最大值
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // 返回最后一个位置的值，即整个字符串的LCS长度
        return dp[n-1][m-1];
    }

}
