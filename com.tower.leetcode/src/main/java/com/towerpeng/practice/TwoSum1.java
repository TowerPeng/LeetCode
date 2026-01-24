package com.towerpeng.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 17:45
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j=0; j<i;j++){
                if(nums[i] + nums[j] == target){
                    newNums[0] = i;
                    newNums[1] = j;
                    break;
                }
            }
        }
        return newNums;
    }

    //hash
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int balance = target - nums[i];
            if(map.containsKey(balance)){
                return new int[]{i, map.get(balance)};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
