package com.towerpeng.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历，左中右
 */
public class InorderTraversal94 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inOrder(root,result);
      return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }

    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return result;
        }
        TreeNode cur = root;
        while(cur!=null && !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
