package com.towerpeng.algorithm.leetcode;

import java.util.*;

public class TestDeleteMaxNum {

    /**
     *
     * 给出n个正整数a(1in)支持两种操作:
     * 1.删除两个相同的数，添加这两个数之和
     * 2.删除两个数，添加这两个数中的最大值已知通过n一1次操作后，只剩下一个数，求这个数的最大值。
     *
     * 第一行输入一个整数n(1<n≤105)第二行输入n个整数Gi(1≤a≤103)
     *
     * @param args
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            arr[i] = x;
        }
        TreeMap<Integer,Integer> sortedMap = new TreeMap<>();
        for(int i:arr){
            sortedMap.merge(i,1,Integer::sum);
        }
        boolean hasMerge = true;
        while(hasMerge){
            hasMerge = false;
            List<Integer> keyList = new ArrayList(sortedMap.keySet());
            for(int key:keyList){
                Integer count = sortedMap.get(key);
                if(count ==null || count<=1){
                    continue;
                }
                hasMerge = true;
                int mergeCount = count/2;
                int remainCount = count%2;
                sortedMap.merge(key*2,mergeCount,Integer::sum);
                if(remainCount==0){
                    sortedMap.remove(key);
                }else{
                    sortedMap.put(key,1);
                }
            }
        }
        System.out.println(sortedMap.lastKey());
    }

    /**
     * 解法二：数组计数 + 贪心
     * 核心思想：从小到大遍历，尽可能合并相同的数
     * 每个数配对后向上传递，实现链式合并
     */
    public static int solution2(int n, int[] arr) {
        // 由于a[i] <= 10^3，合并后最大可能达到 10^3 * 2^17 左右
        // 用数组计数，范围放大到足够容纳合并后的数
        int maxVal = 100001;
        int[] count = new int[maxVal];

        for (int x : arr) {
            count[x]++;
        }

        // 从小到大遍历，进行合并
        for (int i = 1; i < maxVal - 1; i++) {
            if (count[i] >= 2) {
                // 每对i合并成一个 2*i
                int pairs = count[i] / 2;
                count[i] = count[i] % 2;  // 保留余数
                count[i * 2] += pairs;     // 合并结果向上传递
            }
        }

        // 找最大值
        for (int i = maxVal - 1; i >= 1; i--) {
            if (count[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution2(n, arr));
    }

}
