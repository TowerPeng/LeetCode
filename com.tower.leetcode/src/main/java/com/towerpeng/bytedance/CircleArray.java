package com.towerpeng.bytedance;

//搜索旋转排序数组
public class CircleArray {


    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]==target){
                return mid;
            }

            //如果左边有序
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //如果右边有序
                if(nums[mid]<target && target<=nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}
