package com.towerpeng.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 *
 *
 *
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 *
 */
public class AverageOfLevels637 {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();
        Queue<TreeNode> que = new LinkedList<>();
        if(root==null){
            return result;
        }
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            Double doubleResult = 0.0;
            for(int i = 0;i<len;i++){
                TreeNode tempNode = que.poll();
                doubleResult+=tempNode.val;
                //下一层元素入列
                if(tempNode.left!=null){
                    que.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    que.offer(tempNode.right);
                }
            }
            result.add(doubleResult/ len);
        }
        return result;
    }
}
