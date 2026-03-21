package com.towerpeng.algorithm.leetcode.array;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 解释：
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 */
public class GroupAnagrams46 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        int len = strs.length;
        if(len==1){
            List<String> path = new ArrayList();
            path.add(strs[0]);
            result.add(path);
            return result;
        }
        Map<String,List<String>> mapString = new HashMap();
        for(int i =0;i<len;i++){
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(mapString.containsKey(key)){
                List<String> strings = mapString.get(key);
                strings.add(str);
            }else{
                List<String> subList = new ArrayList<>();
                subList.add(str);
                mapString.put(key,subList);
            }
        }
        mapString.entrySet().forEach(entry->{
            result.add(entry.getValue());
        });
        return result;
    }

}
