package com.towerpeng.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //输入整数
        int count = 0;
        if(n==1){
            System.out.print(1);
            return;
        }
        List<List<Integer>> result = new ArrayList();
        LinkedList<Integer> path = new LinkedList();
        path.add(n);
        backTracking(n,0,result,path);
        System.out.print(result.size());
    }

    private static void backTracking(int n,int startIndex,List<List<Integer>> result,LinkedList<Integer>  path){
        int mid = n/2;
        if(path.size()<=mid && !result.contains(path) && startIndex<n){
            result.add(path);
            return;
        }
        for(int i = startIndex;i<n;i++){
            if(i<=mid){
                path.add(i);
                backTracking(n,i,result,path);
                path.removeLast();
            }
        }
    }
}
