package com.towerpeng.practice.greedy;

/**
 *
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 示例 1:
 *
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: n = 332
 * 输出: 299
 *
 *
 * @Author: 彭涛
 * @Date: 2026/2/3 16:28
 */
public class MonotoneIncreasingDigits738 {

    public int monotoneIncreasingDigits(int n) {
        // 将整数n转换为字符串，方便逐位处理
        String s = String.valueOf(n);
        // 将字符串转换为字符数组，以便修改每一位的数字
        char[] chars = s.toCharArray();
        // 初始化start为字符串长度，这个变量用于记录从哪个位置开始后面都变成9
        int start = s.length();
        // 从倒数第二个字符开始向前遍历，因为我们要比较当前位和下一位
        for (int i = s.length() - 2; i >= 0; i--) {
            // 如果当前位的数字大于下一位的数字，说明不满足单调递增的条件
            if (chars[i] > chars[i + 1]) {
                // 将当前位的数字减1，因为为了使得数字尽可能大，我们需要在保持递增的条件下尽可能保留高位数字
                // 例如：n=332，当i=1时，'3'>'2'，那么将chars[1]减1变为'2'，此时数字变为322
                chars[i]--;
                // 记录需要变为9的起始位置，即当前位的下一位开始都要变成9
                // 这是因为当我们减小了当前位，为了保证数字最大且满足递增，后面所有位都变成9是最大的
                start = i + 1;
            }
        }
        // 从start位置开始，将后面所有位都变成9
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        // 将字符数组转换为字符串，再转换为整数返回
        return Integer.parseInt(String.valueOf(chars));
    }
}
