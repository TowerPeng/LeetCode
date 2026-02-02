package com.towerpeng.practice.greedy;

/**
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * @Author: 彭涛
 * @Date: 2026/2/2 17:55
 */
public class Candy135 {


    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        //遍历评分，如果左边比右边高，则右边的糖果数量比左边多1
        for(int i = 1;i< len;i++){
            candyVec[i] = ratings[i] > ratings[i-1] ? candyVec[i-1]+1 : 1;
        }

        //遍历评分，如果右边比左边高，则左边糖果数量比右边多1
        for(int i = len-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        //存结果
        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }
}
