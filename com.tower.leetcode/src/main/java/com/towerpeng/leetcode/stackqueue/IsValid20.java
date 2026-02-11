package com.towerpeng.leetcode.stackqueue;

import java.util.Stack;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 *
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 *
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 *
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([])"
 *
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：s = "([)]"
 *
 * 输出：false
 *
 *
 *
 */

/**
 * 需要注意：从右括号匹配，而不是左括号
 */
public class IsValid20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            //如果有匹配的元素，则弹出
            if(c ==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else if (c==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else if(c=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
