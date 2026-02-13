package com.towerpeng.leetcode.dynamic.bag;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * @Author: 彭涛
 * @Date: 2026/2/13 13:51
 */
public class Rob213 {

    public int rob(int[] nums) {
        if(nums.length ==0) return 0;
        if(nums.length ==1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0],nums[1]);
        int [] dp = new int [nums.length];
        int len = nums.length;
        dp[0] = 0;
        dp[1] = nums[1];
        //偷第一间，不偷最后一间：即范围从0到len-2
        //偷最后一间，不偷第一间：即范围从1到len-1
        return Math.max(robAction(nums, 0, len - 2), robAction(nums, 1, len-1));
    }

    //从0开始，或者从1开始
    //dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
    private int robAction(int [] nums,int start,int end){
        if (end == start) return nums[start];
        int [] dp = new int [nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
