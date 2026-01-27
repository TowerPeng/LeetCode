package com.towerpeng.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 彭涛
 * @Date: 2026/1/26 9:51
 */
public class MinDepth111 {

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

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        int result = 0;
        while(!que.isEmpty()){
            int size = que.size();
            result ++;
            for(int i = 0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left==null && node.right ==null){
                    return result;
                }
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
        }
        return result;
    }

}
