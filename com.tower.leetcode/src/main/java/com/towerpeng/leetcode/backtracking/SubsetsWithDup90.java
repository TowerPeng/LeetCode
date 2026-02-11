package com.towerpeng.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class SubsetsWithDup90 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums,0);
        return result;
    }

    private void backTrack(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        if(startIndex>=nums.length){
            return;
        }
        for(int i = startIndex;i<nums.length;i++){
            if(i>0&& nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrack(nums,i+1);
            path.removeLast();
            used[i] = false;
        }
    }
}
