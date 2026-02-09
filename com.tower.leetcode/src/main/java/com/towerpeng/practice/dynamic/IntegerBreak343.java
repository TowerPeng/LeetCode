package com.towerpeng.practice.dynamic;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * @Author: 彭涛
 * @Date: 2026/2/6 9:47
 */
public class IntegerBreak343 {

    /**
     * 数学公式
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int k = n / 3;
        int r = n % 3;

        if (r == 0) {
            return (int)Math.pow(3, k);
        } else if (r == 1) {
            return 4 * (int)Math.pow(3, k - 1);
        } else { // r == 2
            return 2 * (int)Math.pow(3, k);
        }
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreakDp(int n) {
        if (n <= 3) return n - 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            // 尝试将i拆分为j和i-j，其中j从1到i-1
            // 优化：由于对称性，j只需要取到i/2
            for (int j = 1; j <= i / 2; j++) {
                //拆分，如果是两个数就是j*(i-j) 如果再拆分就是j*dp[i-j]
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }

        return dp[n];
    }

    public int integerBreakDp2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int [] dp = new int [n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j] ));
            }
        }
        return dp[n];
    }
}
