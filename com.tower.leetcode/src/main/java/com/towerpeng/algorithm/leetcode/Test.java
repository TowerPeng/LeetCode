package com.towerpeng.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        //输入整数
//        int count = 0;
//        if(n==1){
//            System.out.print(1);
//            return;
//        }
//        List<List<Integer>> result = new ArrayList();
//        LinkedList<Integer> path = new LinkedList();
//        path.add(n);
//        backTracking(n,0,result,path);
//        System.out.print(result.size());

//        System.out.println(findMaxK(new int[]{-1,10,6,7,-7,1}));

        //[[5,10],[2,5],[4,7],[3,9]]
//        System.out.println(maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10));



    }

    private static void backTracking(int n,int startIndex,List<List<Integer>> result,LinkedList<Integer>  path){
        int mid = n/2;
        if(path.size()<=mid && !result.contains(path) && startIndex<n){
            result.add(path);
            return;
        }
        for(int i = startIndex;i<n;i++){
            if(i<=mid){
                path.add(i);
                backTracking(n,i,result,path);
                path.removeLast();
            }
        }
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]==-nums[nums.length-1]){
            return nums[nums.length-1];
        }
        return -1;
    }


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt((int[] a) -> a[1]).reversed());
        int result = 0;
        for(int i = 0;i<boxTypes.length;i++){
            if(truckSize>=boxTypes[i][0]){
                truckSize-=boxTypes[i][0];
                result+=boxTypes[i][0]*boxTypes[i][1];
            }else{
                result+=truckSize*boxTypes[i][1];
                break;
            }
        }
        return result;
    }


}
