package com.towerpeng.practice;

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
}
