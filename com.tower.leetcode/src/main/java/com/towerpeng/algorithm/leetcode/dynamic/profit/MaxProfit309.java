package com.towerpeng.algorithm.leetcode.dynamic.profit;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 * @Author: 彭涛
 * @Date: 2026/2/24 9:13
 */
public class MaxProfit309 {

    //状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
    //不持有股票状态，这里就有两种卖出股票状态
    //状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
    //状态三：今天卖出股票
    //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
    //dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][3]- prices[i], dp[i - 1][1]- prices[i]) );
    //dp[i][1] = max(dp[i - 1][1], dp[i - 1][3]);
    //dp[i][2] = dp[i - 1][0] + prices[i];
    //dp[i][3] = dp[i - 1][2];
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] -= prices[0]; // 持股票
        dp[0][1] = 0;// 保持卖出股票的状态
        dp[0][2] = 0;// 今天卖出股票
        dp[0][3] = 0;// 冷冻期
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
