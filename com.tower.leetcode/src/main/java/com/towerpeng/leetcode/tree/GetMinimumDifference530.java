package com.towerpeng.leetcode.tree;

/**
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * 示例 1：
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * @Author: 彭涛
 * @Date: 2026/1/28 13:37
 */
public class GetMinimumDifference530 {

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


    TreeNode pre; // 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return;
        // 左
        traversal(root.left);
        // 中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        // 右
        traversal(root.right);
    }

}
