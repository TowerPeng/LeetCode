package com.towerpeng.practice;

import java.util.Stack;

/**
 *
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 s 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 */
public class RemoveDuplicates1047 {

    public static String removeDuplicates(String s) {

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i =0 ;i <charArray.length;i++){
            char c = charArray[i];
            if(!stack.isEmpty() && c==stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        String str = "";
        for(Character c : stack){
            str += c;
        }
        return str;
    }

    public String removeDuplicates2(String s) {
        char[] ch = s.toCharArray();
        int fast=0;
        int slow=0;
        while(fast<s.length()){
            ch[slow] = ch[fast];
            if( slow>0 && ch[slow]== ch[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
