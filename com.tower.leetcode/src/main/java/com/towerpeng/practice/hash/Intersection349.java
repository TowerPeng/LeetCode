package com.towerpeng.practice.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 17:23
 */
public class Intersection349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int num :nums1){
            set.add(num);
        }
        Set<Integer> set2 = new HashSet();
        for(int num :nums2){
            set2.add(num);
        }
        Set<Integer> set3 = new HashSet();
        for(Integer i: set){
            if(set2.contains(i)){
                set3.add(i);
            }
        }
        return set3.stream().mapToInt(Integer::intValue).toArray();
    }
}
