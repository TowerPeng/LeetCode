package com.towerpeng.leetcode.greedy;

/**
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @Author: 彭涛
 * @Date: 2026/2/2 15:29
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        //数组小于1时，直接返回数组第一个元素
        if(nums.length<=1){
            return nums[0];
        }
        int count = 0;
        int sum = Integer.MIN_VALUE;
        for (int num : nums) {
            count += num;
            sum = Math.max(sum, count);// 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }
}
