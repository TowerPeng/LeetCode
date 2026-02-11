package com.towerpeng.leetcode.tree;

/**
 *给定一个二叉树，判断它是否是 平衡二叉树
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *
 * @Author: 彭涛
 * @Date: 2026/1/26 13:37
 */
public class IsBalanced110 {

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

    /**
     * 递归计算平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        //返回-1为不平衡
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }
        //左右高度差大于1
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
