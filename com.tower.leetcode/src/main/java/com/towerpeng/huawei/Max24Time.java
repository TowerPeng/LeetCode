package com.towerpeng.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 给定一个数组，里面有 6 个整数，求这个数组能够表示的最大 24 进制的时间是多少，输出这个时间，无法表示输出 invalid。
 * 输入描述
 * 输入为一个整数数组，数组内有六个整数。
 * 输入整数数组长度为 6，不需要考虑其它长度，元素值为 0 或者正整数，6 个数字每个数字只能使用一次。
 * 输出描述
 * 输出为一个 24 进制格式的时间，或者字符串 ”invalid“。
 * 用例
 * 输入	[0,2,3,0,5,6]
 * 输出	23:56:00
 * 说明	无
 * @Author: 彭涛
 * @Date: 2026/2/28 9:37
 */
public class Max24Time {

    // 预编译正则表达式，用于验证时间格式
    private static final Pattern TIME_PATTERN =
            Pattern.compile("(([01][0-9])|([2][0-3])):([0-5][0-9]):([0-5][0-9])");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        // 从输入中提取所有数字字符
        List<Integer> digits = new ArrayList<>();
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digits.add(c - '0');
            }
        }
        // 输入保证正好有6个数字，但做健壮性检查
        if (digits.size() != 6) {
            System.out.println("invalid");
            return;
        }

        // 转为数组方便使用
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = digits.get(i);
        }

        boolean[] used = new boolean[6];
        int[] current = new int[6];
        List<String> validTimes = new ArrayList<>();

        // 回溯生成所有排列
        backtrack(0, nums, used, current, validTimes);

        if (validTimes.isEmpty()) {
            System.out.println("invalid");
        } else {
            // 直接取最大字符串（字典序即时间先后）
            String maxTime = Collections.max(validTimes);
            System.out.println(maxTime);
        }
    }

    private static void backtrack(int pos, int[] nums, boolean[] used,
                                  int[] current, List<String> validTimes) {
        if (pos == 6) {
            // 构造时间字符串
            String time = String.format("%d%d:%d%d:%d%d",
                    current[0], current[1],
                    current[2], current[3],
                    current[4], current[5]);
            // 用正则校验
            if (TIME_PATTERN.matcher(time).matches()) {
                validTimes.add(time);
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!used[i]) {
                used[i] = true;
                current[pos] = nums[i];
                backtrack(pos + 1, nums, used, current, validTimes);
                used[i] = false;
            }
        }
    }
}
