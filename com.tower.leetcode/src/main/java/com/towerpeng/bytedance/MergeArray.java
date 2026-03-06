package com.towerpeng.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入： [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeArray {

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            //如果左边界大于最大右边界
            if(intervals[i][0]>rightmostRightBound){
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

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

}
