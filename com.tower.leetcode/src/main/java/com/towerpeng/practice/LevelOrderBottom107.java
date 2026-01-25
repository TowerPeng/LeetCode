package com.towerpeng.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

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
            //与深度遍历不同，需要添加到头，可实现倒序，双向队列，前插
            result.addFirst(itemList);
        }
        return result;
    }
}
