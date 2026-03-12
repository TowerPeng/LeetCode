package com.towerpeng.algorithm.leetcode.singlestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @Author: 彭涛
 * @Date: 2026/2/27 13:40
 */
public class DailyTemperatures739 {

    //单调递增栈，过程画图理解
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int lens=temperatures.length;
        int []res=new int[lens];
        stack.push(0);
        for(int i=1;i<lens;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                //当前元素小于等于栈顶元素，直接压入栈
                stack.push(i);
            }else{
                //当前元素大于栈顶元素
                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                //当前元素入栈
                stack.push(i);
            }
        }
        return res;
    }
}
