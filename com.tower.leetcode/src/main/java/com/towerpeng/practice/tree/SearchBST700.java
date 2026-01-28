package com.towerpeng.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 示例 1:
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * 示例 2:
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 * @Author: 彭涛
 * @Date: 2026/1/28 11:14
 */
public class SearchBST700 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == val){
                    return node;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if(root==null){
            return root;
        }
        if(val==root.val){
            return root;
        }
        TreeNode result = null;
        if(val<root.val){
            result = searchBST(root.left,val);
        }
        if(val>root.val){
            result = searchBST(root.right,val);
        }
        return result;

    }

    public TreeNode searchBST3(TreeNode root, int val){
        while(root!=null){
            if(val<root.val){
                root = root.left;
            }
            else if(val>root.val){
                root = root.right;
            }
            else
                return root;
        }
        return null;
    }
}
