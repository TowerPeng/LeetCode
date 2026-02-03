package com.towerpeng.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *  示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 *
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 *
 * @Author: 彭涛
 * @Date: 2026/2/3 16:15
 */
public class Merge56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //initial start 是最小左边界
        int start = intervals[0][0];
        //初始右边界是最小右边界
        int rightmostRightBound = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            //如果左边界大于最大右边界
            if(intervals[i][0]>rightmostRightBound){
                //加入区间 并且更新start
                res.add(new int[]{start,rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            }else{
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound,intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}
