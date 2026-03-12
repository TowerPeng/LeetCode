package com.towerpeng.algorithm.bytedance;

import java.util.HashMap;
import java.util.Map;

public class OneNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
}
