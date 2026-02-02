package com.towerpeng.practice.greedy;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
 *
 * 示例 1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。
 * 所以你应该输出 1。
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出 2。
 *
 * @Author: 彭涛
 * @Date: 2026/2/2 9:08
 */
public class FindContentChildren455 {

    //优先满足大胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length-1;
        for(int i = g.length-1;i>=0;i--){
            if(index>=0 && s[index]>=g[i]){
                result++;
                index--;
            }
        }
        return result;
    }


    //优先满足胃口小的
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for(int i = 0;i<s.length && start<g.length;i++){
            if(s[i]>=g[start]){
                count++;
                start++;
            }
        }
        return count;
    }

    //双指针，优先满足小胃口
    public int findContentChildren3(int[] g, int[] s) {
        Arrays.sort(g);  // 孩子胃口升序
        Arrays.sort(s);  // 饼干大小升序
        int childIndex = 0;
        int cookieIndex = 0;
        // 用最小的饼干满足最小的孩子
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++;  // 孩子被满足
            }
            cookieIndex++;  // 无论是否满足，饼干都被尝试使用
        }

        return childIndex;  // 被满足的孩子数量
    }
}
