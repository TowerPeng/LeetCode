package com.towerpeng.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 */
public class LevelOrder102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que = new LinkedList<>();
        //头结点入列
        que.offer(root);
        //队列不为空
        while(!que.isEmpty()){
            List<Integer> itemList = new ArrayList<Integer>();
            //本层的元素数量
            int len = que.size();
            while(len>0){
                TreeNode tempNode = que.poll();
                itemList.add(tempNode.val);
                //下一层元素入列
                if(tempNode.left!=null){
                    que.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    que.offer(tempNode.right);
                }
                len--;
            }
            result.add(itemList);
        }
        return result;
    }

}
