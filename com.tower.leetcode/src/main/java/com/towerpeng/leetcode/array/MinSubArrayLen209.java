package com.towerpeng.leetcode.array;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 15:45
 */
public class MinSubArrayLen209 {

    /**
     *
     给定一个含有 n 个正整数的数组和一个正整数 target 。

     找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     示例 1：

     输入：target = 7, nums = [2,3,1,2,4,3]
     输出：2
     解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     示例 2：

     输入：target = 4, nums = [1,4,4]
     输出：1
     示例 3：

     输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     输出：0

     */

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0;right<nums.length;right++){
            sum+=nums[right];
            //左侧指针移动，滑动窗口
            while(sum>=target){
                result = Math.min(right-left+1,result);
                sum-=nums[left];
                left++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(4,nums));
    }



}
