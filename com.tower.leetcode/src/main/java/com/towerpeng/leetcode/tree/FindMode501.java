package com.towerpeng.leetcode.tree;


import java.util.ArrayList;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：[0]
 */
public class FindMode501 {
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


    //双指针中序遍历
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;

        findMode1(root);
        int [] rest = new int[]{};
        for (int i = 0;i<resList.size();i++){
            rest[i] = resList.get(i);
        }
        return rest;
    }


    private void findMode1(TreeNode root){
        if(root==null){
            return;
        }
        //左
        findMode1(root.left);
        int rootValue = root.val;
        //中  单一元素出现的频率统计
        if(pre==null){
            count = 1;
        }else if(pre.val == root.val){
            count++;
        }else{
            count = 1;
        }

        pre = root;

        if(count == maxCount){
            resList.add(rootValue);
        }else if(count > maxCount){
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        }
        //右
        findMode1(root.right);

    }
}
