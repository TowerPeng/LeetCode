package com.towerpeng.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 彭涛
 * @Date: 2026/1/26 10:55
 */
public class IsSymmetric101 {
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
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right != null) {
            return false;
        }
        if(left!=null && right==null){
            return false;
        }
        if(left==null && right==null){
            return true;
        }
        if(left.val!=right.val){
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }


    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right==null){
                continue;
            }
            if(left==null || right==null || left.val!=right.val){
                return false;
            }
            //左子树的左节点（最外层）
            queue.offer(left.left);
            //右子树的右节点
            queue.offer(right.right);
            //左子树的右节点（内层）
            queue.offer(left.right);
            //右子树的左节点
            queue.offer(right.left);
        }
        return true;
    }
}
