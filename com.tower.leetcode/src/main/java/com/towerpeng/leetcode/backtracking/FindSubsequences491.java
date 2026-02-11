package com.towerpeng.leetcode.backtracking;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 */
public class FindSubsequences491 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0);
        return result;
    }

    private void backTrack(int [] nums,int startIndex){
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIndex;i<nums.length;i++){
            //当前数字小于最大元素 或者存在重复元素
            if(!path.isEmpty() && nums[i] < path.get(path.size()-1) || hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }

}
