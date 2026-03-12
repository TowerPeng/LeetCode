package com.towerpeng.algorithm.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * @Author: 彭涛
 * @Date: 2026/3/6 18:10
 */
public class Generate118 {

    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int [][]dp = new int[numRows][numRows];
        dp[0][0] = 1;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        for (int i = 1; i < numRows; i++) {
            for(int j= 0 ;j<=i;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                tmp.add(dp[i][j]);
            }
            res.add( tmp);
        }
        return res;
    }
}
