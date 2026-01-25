package com.towerpeng.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3], k = 2
 *
 * 输出：[1,2]
 *
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 *
 * 输出：[1]
 *
 * 示例 3：
 *
 * 输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 *
 * 输出：[1,2]
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class TopKFrequent347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if(k<=0){
            return result;
        }
        Map<Integer,Integer> countMap = new HashMap();
        for(int i = 0;i<nums.length;i++){
            int x = nums[i];
            countMap.put(x,countMap.getOrDefault(x,0)+1);
        }
        //1,4  2,4,   3,2
        List<Map.Entry<Integer, Integer>> sortedByValue = countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for(int j = 0;j<k;j++){
            Map.Entry<Integer, Integer> integerIntegerEntry = sortedByValue.get(j);
            result[j] = integerIntegerEntry.getKey();
        }
        return result;
    }


    public int[] topKFrequent2(int[] nums, int k) {
        // 优先级队列，为了避免复杂 api 操作，pq 存储数组
        // lambda 表达式设置优先级队列从大到小存储 o1 - o2 为从小到大，o2 - o1 反之
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k]; // 答案数组为 k 个元素
        Map<Integer, Integer> map = new HashMap<>(); // 记录元素出现次数
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (var x : map.entrySet()) { // entrySet 获取 k-v Set 集合
            // 将 kv 转化成数组
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();
            pq.offer(tmp);
            // 下面的代码是根据小根堆实现的，我只保留优先队列的最后的k个，只要超出了k我就将最小的弹出，剩余的k个就是答案
            if(pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0]; // 获取优先队列里的元素
        }
        return res;
    }


}
