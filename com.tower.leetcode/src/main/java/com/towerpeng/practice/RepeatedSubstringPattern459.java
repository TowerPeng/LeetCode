package com.towerpeng.practice;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern459 {

    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1,ss.length()-1).contains(s);
    }

    /**
     * n % (n - next[n - 1]) == 0
     * 求取next数组，如果满足以上等式则是重复子串
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatternKmp(String s) {

        int n = s.length();
        int [] next = new int [n];
        int j = 0;
        for(int i = 0;i<n;i++){
            if(i==0){
                //第一个字符没有前缀
                next[i] = 0;
            }
            //不相同，则回退j
            while(j>0&& s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        int lastNext = next[n-1];
        int unitLen = n- lastNext;
        return lastNext>0 && n%unitLen==0;
     }



}
