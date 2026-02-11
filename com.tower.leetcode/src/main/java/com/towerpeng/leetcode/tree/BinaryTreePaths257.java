package com.towerpeng.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 * @Author: 彭涛
 * @Date: 2026/1/26 13:43
 */
public class BinaryTreePaths257 {

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

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        deal(root, "");
        return result;
    }

    public void deal(TreeNode node, String s){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            result.add(s + node.val);
            return;
        }
        String tmp = s + node.val + "->";
        deal(node.left, tmp);
        deal(node.right, tmp);
    }

}
