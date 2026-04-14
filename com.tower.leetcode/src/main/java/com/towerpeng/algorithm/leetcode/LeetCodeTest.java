package com.towerpeng.algorithm.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 9:08
 */
public class LeetCodeTest {

    public static void main(String[] args) {
//        LeetCodeTest leetCodeTest = new LeetCodeTest();
//        System.out.println(leetCodeTest.isAnagram("anagram", "nagaram"));
//        int [] list = {1,1,4,2,1,3};
//        int [] list2 = {1,2,2};
//        int[] intersection = leetCodeTest.intersection(list, list2);
//        for (int i = 0; i < intersection.length; i++){
//            System.out.print(intersection[i]);
//        }
//        System.out.println(heightChecker( list));

//        int[][] items1 = {{5, 1}, {4, 2}, {3, 3},{2,4}, {1,5}};
//        int[][] items2 = {{7, 1}, {6, 2}, {5, 3}, {4, 4}};
//        System.out.println(mergeSimilarItems(items1, items2));

//        arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
//        int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
//        System.out.println(trimMean(arr));

//        int[] nums = {9,5,7,8,7,9,8,2,0,7};
//        distinctAverages(nums);
//        [6, 1, 3, 1, 1, 1]
//        int[] nums = {6,1,3,1,1,1};
//        inventoryManagement(nums);
//
//        mat =
        int[][] mat = {{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        kWeakestRows(mat,3);
    }



    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Arrays.stream(items1).forEach(item->map.put(item[0],item[1]));
        Arrays.stream(items2).forEach(item->map.put(item[0],map.getOrDefault(item[0],0)+item[1]));
        return map.entrySet().stream().map(entry->Arrays.asList(entry.getKey(),entry.getValue())).collect(Collectors.toList());
    }

    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        bulbs = bulbs.stream().sorted().collect(Collectors.toList());
        Deque<Integer> queue = new LinkedList();
        queue.offer(bulbs.get(0));
        for(int i = 1;i<bulbs.size();i++){
            if(queue.size()!=0){
                int temp = queue.peekLast();
                if(temp==bulbs.get(i)){
                    queue.pollLast();
                }else{
                    queue.offer(bulbs.get(i));
                }
            }else{
                queue.offer(bulbs.get(i));
            }
        }
        return queue.stream().collect(Collectors.toList());
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

    public String[] sortPeople(String[] names, int[] heights) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], heights[i]);
        }

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).toArray(String[]::new);
    }

    public int[] intersection4(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return map.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<Integer, Integer> a) -> a.getValue()).thenComparingInt(Map.Entry::getKey))
                .mapToInt(Map.Entry::getKey)
                .toArray();    }

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
    public static int heightChecker(int[] heights) {
        int [] original = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            original[i] = heights[i];
        }
        Arrays.sort(heights);
        int count = 0;
        for(int i =0;i<heights.length;i++){
            if(original[i]!=heights[i]){
                count ++;
            }
        }
        return count;
    }

    public static double trimMean(int[] arr) {
        Arrays.sort( arr);
        arr = Arrays.copyOfRange(arr, 0, arr.length - -1);
        int sum = Arrays.stream(arr).sum();
        return sum / arr.length;
    }


    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i :nums){
            set.add(i);
        }
        int ans[] = new int [k];
        int j = 0;
        for(int i:set){
            if(j<k){
                ans[j++] = i;
            }
        }
        return Arrays.copyOf(ans,j);
    }

    public boolean isUnique(String astr) {
        char[] charArr = astr.toCharArray();
        Arrays.sort(charArr);
        for(int i = 1;i<charArr.length;i++){
            if(charArr[i]==charArr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        Set<Double> set = new HashSet();
        while(left<right){
            int a = nums[left];
            int b = nums[right];
            Double dou = Double.valueOf((a + b) / (double)2);
            set.add(dou);
            left++;
            right--;
        }
        return set.size();
    }

    public static int inventoryManagement(int[] stock) {
        if (stock == null || stock.length == 0) return -1;
        int len = stock.length;
        int temp = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : stock) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > temp) return num;  // 直接返回，无需遍历完
            map.put(num, count);
        }
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(s.length());
        return -1;  // 没找到

    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> validIndices = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (isValid(code[i]) && isValidBusiness(businessLine[i]) && isActive[i]) {
                validIndices.add(i);
            }
        }
        List<String> businessOrder = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        validIndices.sort(Comparator
                .comparingInt((Integer i) -> businessOrder.indexOf(businessLine[i]))
                .thenComparing(i -> code[i]));
        List<String> result = new ArrayList<>();
        for (int i : validIndices) {
            result.add(code[i]);
        }
        return result;
    }
    public boolean isValidBusiness(String s ){
        return s.equals("electronics") || s.equals("grocery") || s.equals("pharmacy") || s.equals("restaurant");
    }

    public static boolean isValid(String s) {
        if (s == null) return false;
        if (s.length()==0) return false;
        return s.matches("^[a-zA-Z0-9_]*$");
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length;
        List<Integer> list = new ArrayList();
        for(int i = 0;i<len;i++){
            int [] row = mat[i];
            int sum = 0;
            for(int j=0;j<row.length;j++){
                if(row[j]==1){
                    sum+=1;
                }
            }
            list.add(sum);
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            indices.add(i);
        }
        indices.sort(Comparator.comparingInt(list::get));
        return indices.stream().mapToInt(Integer::intValue).limit(k).toArray();
    }
}
