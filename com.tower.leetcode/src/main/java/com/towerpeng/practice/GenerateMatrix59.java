package com.towerpeng.practice;

/**
 * @Author: 彭涛
 * @Date: 2026/1/23 15:56
 */
public class GenerateMatrix59 {

    /**
     *
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     *
     */
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int [n][n];
        int count = 1;
        int offset= 1;
        int loop = 1;
        int startX = 0, startY = 0;
        int i,j;
        while(loop<=n/2){
            //第一行，固定X，移动Y，行不动，列递增
            for(j = startY;j<n-offset;j++){
                nums[startX][j] = count++;
            }
            //最后一列，固定Y，移动X，列不动，行递增
            for(i = startX;i<n-offset;i++){
                nums[i][j] = count++;
            }
            //最后一行
            for (;j>startY;j--){
                nums[i][j] = count++;
            }
            //第一列
            for (;i>startX;i--){
                nums[i][j] = count++;
            }
            offset++;
            startX++;
            startY++;
            loop++;
        }
        //奇数的时候，中间位置赋值
        if(n%2==1){
            nums[startX][startY] = count;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(6);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
