package com.towerpeng.practice.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 18:32
 */
public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length<4){
            return result;
        }
        int n = nums.length;
        for(int i = 0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //最小4个数之和 still > target
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3]>target){
                break;
            }
            //当前数+最大三个数 still < target
            if((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] <target){
                continue;
            }
            for(int j = i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                if((long)nums[i] +nums[j] + nums[j+1] + nums[j+2]>target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[n-2] + nums[n-1] <target){
                    continue;
                }
                int left = j+1;
                int right = n-1;
                while(left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

}
