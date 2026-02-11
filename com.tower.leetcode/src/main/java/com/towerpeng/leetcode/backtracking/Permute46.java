package com.towerpeng.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Permute46 {


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;


    public List<List<Integer>> permute(int[] nums) {
        if(nums.length ==0){
            return result;
        }
        backTrack(nums,path);
        return result;
    }

    private void backTrack(int []nums,LinkedList<Integer> path){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //注意，与之前遍历不同，他仍然是从第一个数开始取而不是startIndex，startIndex需要记录当前位置开始
        for(int i = 0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backTrack(nums,path);
            path.removeLast();
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        if(nums.length ==0){
            return result;
        }
        used = new boolean[nums.length];
        backTrack1(nums);
        return result;
    }

    private void backTrack1(int []nums){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //
        for(int i = 0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack1(nums);
            path.removeLast();
            used[i] = false;
        }

    }
}
