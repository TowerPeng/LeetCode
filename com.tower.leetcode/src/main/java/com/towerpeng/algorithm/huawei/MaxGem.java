package com.towerpeng.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述
 * 橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为 gems[i]
 * 0 ≤ i < n
 * n = gems.length
 * 宝石可同时出售0个或多个，如果同时出售多个，则要求出售的宝石编号连续；
 * 例如客户最大购买宝石个数为m，购买的宝石编号必须为：gems[i]，gems[i+1]，...，gems[i+m-1]
 * 0 ≤ i < n
 * m ≤ n
 * 假设你当前拥有总面值为 value 的钱，请问最多能购买到多少个宝石，如无法购买宝石，则返回0。
 *
 * 输入描述
 * 第一行输入n，参数类 型为int，取值范围：[0,10^6]，表示橱窗中宝石的总数量。
 *
 * 之后 n 行分别表示从第0个到第n-1个宝石的价格，即 gems[0] 到 gems[n-1] 的价格，类型为int，取值范围：(0,1000]。
 *
 * 之后一行输入v，类型为int，取值范围：[0,10^9]，表示你拥有的钱。
 *
 * 输出描述
 * 输出int类型的返回值，表示最大可购买的宝石数量。
 *
 * @Author: 彭涛
 * @Date: 2026/2/28 9:33
 */
public class MaxGem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取宝石数量
        int n = sc.nextInt();
        int[] gems = new int[n];

        // 读取每个宝石的价格
        for (int i = 0; i < n; i++) {
            gems[i] = sc.nextInt();
        }

        // 读取拥有的钱
        int v = sc.nextInt();
        sc.close();

        // 滑动窗口求解最大连续子数组长度，使得和 ≤ v
        int maxLen = 0;
        long sum = 0;       // 窗口内宝石总价，使用 long 防止溢出
        int left = 0;

        for(int right = 0;right<n;right++){
            sum += gems[right];
            while(sum<v && left<=right){
                sum -= gems[left];
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        // 输出结果
        System.out.println(maxLen);
    }
}
