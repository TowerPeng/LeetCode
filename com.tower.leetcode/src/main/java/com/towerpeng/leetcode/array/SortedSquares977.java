package com.towerpeng.leetcode.array;

import java.util.Arrays;

/**
 * 排序平方和
 *
 * @Author: 彭涛
 * @Date: 2026/1/23 15:32
 */
public class SortedSquares977 {

    public static int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = nums[i]*nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    //指针方法，快慢指针
    public static int[] sortedSquaresPonter(int[] nums) {
        int [] result = new int[nums.length];
        int fastIndex = nums.length-1;
        int slowIndex = 0;
        int num = nums.length -1;
        while(num>=0){
            if(nums[slowIndex] * nums[slowIndex] > nums[fastIndex] * nums[fastIndex]){
                result[num] = nums[slowIndex] * nums[slowIndex];
                slowIndex++;
            }else{
                result[num] = nums[fastIndex] * nums[fastIndex];
                fastIndex--;
            }
            num--;
        }
        return result;
    }


    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        int[] ints = sortedSquaresPonter(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
