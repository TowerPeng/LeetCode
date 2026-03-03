package com.towerpeng.leetcode.tree;

import java.util.*;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 *
 * 示例1：
 *
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *
 */
public class LargestValues515 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0;i<len;i++){
                TreeNode poll = queue.poll();
                tempList.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            Integer i = tempList.stream().max(Comparator.comparingInt(Integer::intValue)).get();
            list.add(i);
        }
        return list;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            //特殊判断，每层可能为负数
            int maxNumber = Integer.MIN_VALUE;
            for(int i = 0;i<len;i++){
                TreeNode temp = que.poll();
                maxNumber = Math.max(temp.val,maxNumber);
                if(temp.left!=null){
                    que.offer(temp.left);
                }
                if(temp.right!=null){
                    que.offer(temp.right);
                }
            }
            result.add(maxNumber);
        }
        return result;
    }
}
