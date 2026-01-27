package com.towerpeng.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 后续遍历-》左右中
 */
public class PostorderTraversal145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root,result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
    }

    //后序遍历，左右中，入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.left!=null){
                stack.push(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
        }
        Collections.reverse(result);
        return result;
    }


}
