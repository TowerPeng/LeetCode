package com.towerpeng.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 示例 1：
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 * @Author: 彭涛
 * @Date: 2026/1/28 11:08
 */
public class MergeTrees617 {

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


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        Queue<TreeNode> que = new LinkedList();
        que.offer(root1);
        que.offer(root2);
        while(!que.isEmpty()){
            TreeNode node1 = que.poll();
            TreeNode node2 = que.poll();
            node1.val += node2.val;
            if(node1.left!=null && node2.left!=null){
                que.offer(node1.left);
                que.offer(node2.left);
            }
            if(node1.right!=null && node2.right!=null){
                que.offer(node1.right);
                que.offer(node2.right);
            }
            //左子树为空，将node2的左子树挂到node1的左子树上
            if(node1.left==null && node2.left!=null){
                node1.left = node2.left;
            }
            //右子树为空，将node2的右子树挂到node1的右子树上
            if(node1.right==null && node2.right!=null){
                node1.right = node2.right;
            }

        }
        return root1;
    }

}
