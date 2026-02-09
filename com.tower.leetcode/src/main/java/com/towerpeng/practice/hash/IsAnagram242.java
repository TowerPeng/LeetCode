package com.towerpeng.practice.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *
 * @Author: 彭涛
 * @Date: 2026/1/23 17:16
 */
public class IsAnagram242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(Character c: charArray){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char[] charArray1 = t.toCharArray();
        for(Character c : charArray1){
            if(!map.containsKey(c)){
                return false;
            }
            int newCount = map.get(c) - 1;
            if(newCount==0){
                map.remove(c);
            }else{
                map.put(c,newCount);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }



}
