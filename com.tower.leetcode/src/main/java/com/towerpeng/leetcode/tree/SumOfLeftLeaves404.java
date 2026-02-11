package com.towerpeng.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 *
 * 输入: root = [1]
 * 输出: 0
 *
 * @Author: 彭涛
 * @Date: 2026/1/27 14:54
 */
public class SumOfLeftLeaves404 {

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
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0;i<len;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                    //左叶子节点判断
                    if(poll.left.left==null&&poll.left.right==null){
                        result+=poll.left.val;
                    }
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }

}
