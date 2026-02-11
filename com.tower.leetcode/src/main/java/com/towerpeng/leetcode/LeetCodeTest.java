package com.towerpeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 9:08
 */
public class LeetCodeTest {

    public static void main(String[] args) {
        LeetCodeTest leetCodeTest = new LeetCodeTest();
//        System.out.println(leetCodeTest.isAnagram("anagram", "nagaram"));
        int [] list = {1,2,3};
        int [] list2 = {1,2,2};
        int[] intersection = leetCodeTest.intersection(list, list2);
        for (int i = 0; i < intersection.length; i++){
            System.out.print(intersection[i]);
        }
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(Character c : charArray){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char[] charArray1 = t.toCharArray();
        for(Character c: charArray1){
            if (!map.containsKey( c)){
                return false;
            }
            int count = map.get(c) - 1;
            if(count==0){
                map.remove(c);
            }else{
                map.put(c,count);
            }
        }
        return map.isEmpty();
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(set::add);
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums2).forEach(set1::add);
        Set<Integer> set2 = new HashSet<>();
        set.forEach(o->{
            if(set1.contains( o)){
                set2.add( o);
            }
        });
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[2];
        for(int i= 0;i<nums.length;i++){
            for(int j= 0;j<i;j++){
                if(nums[i] + nums[j] == target){
                    newNums[0] = i;
                    newNums[1] = j;
                    break;
                }
            }
        }
        return newNums;
    }

    public int[] twoSumHash(int[] nums, int target) {
        //临时存放遍历过的元素
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            //遍历数组，计算差值
            int balance = target - nums[i];
            //如果存在key为balance的元素，则返回结果
            if(map.containsKey(balance)){
                return new int[]{i, map.get(balance)};
            }else{
                //否则把访问过的元素放进临时map
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int k : nums3) {
            for (int i : nums4) {
                if (map.containsKey(-(k + i))) {
                    count += map.get(-(k + i));
                }
            }
        }
        return count;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //排序后双指针
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            //第一个元素大于0，不可能组成三元组等于0
            if(nums[0]>0){
                return result;
            }
            //去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //左指针=i+1
            int left = i + 1;
            //右指针=数组长度-1，下标
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //三元组去重
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    //和太大，右指针左移
                    right --;
                }else {
                    //和太小，左指针右移
                    left++;
                }
            }
        }
        return result;
    }

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

            //最小四个数之和仍大于target
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3]>target){
                break;
            }
            //当前数与最大数之和仍小于target
            if((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] <target){
                continue;
            }
            //固定第二个数字
            for(int j =i +1; j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j+1] + nums[j+2]> target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[n-2] + nums[n-1]<target){
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while(left<right ){

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right] ==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;

                    }else if(sum>target){
                        right--;

                    }else{
                        left++;

                    }
                }
            }
        }
        return result;
    }
}
