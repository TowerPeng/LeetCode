package com.towerpeng.practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * @Author: 彭涛
 * @Date: 2026/1/28 10:48
 */
public class BuildTree105 {
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 如果前序序列为空，则二叉树为空树
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 创建哈希表，用于快速查找中序遍历中每个值对应的索引位置
        // key: 节点值, value: 在中序数组中的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 调用递归辅助函数，传入数组边界和哈希表
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                map);

    }
    // 递归辅助函数，用于构建二叉树
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> map) {
        // 递归终止条件：如果前序或中序的起始位置超过结束位置，说明当前子树为空
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的第一个节点是当前子树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 在中序遍历中找到根节点的位置，用于分割左右子树
        int inRootIndex = map.get(root.val);

        // 计算左子树的节点数量（中序中根节点左边的节点数）
        int leftTreeSize = inRootIndex - inStart;

        // 递归构建左子树：
        // 前序中左子树范围：从preStart+1开始，长度为leftTreeSize
        // 中序中左子树范围：从inStart开始，到inRootIndex-1结束
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, inRootIndex - 1,
                map);

        // 递归构建右子树：
        // 前序中右子树范围：左子树之后的部分，到preEnd结束
        // 中序中右子树范围：从inRootIndex+1开始，到inEnd结束
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd,
                map);

        // 返回构建好的子树根节点
        return root;
    }

    /**
     * 迭代
     * 前序遍历：根左右
     * 中序遍历：左根右
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 如果前序序列为空，则二叉树为空树
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 前序遍历的第一个节点是整棵树的根节点
        TreeNode root = new TreeNode(preorder[0]);

        // 使用栈来保存尚未处理右子树的节点
        // 栈中的节点都是已经创建了左子树但右子树还未处理的节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 中序遍历的索引，从第一个元素开始
        int inorderIndex = 0;

        // 遍历前序数组，从第二个元素开始（第一个已经是根节点）
        for (int i = 1; i < preorder.length; i++) {
            // 获取当前要处理的节点值
            int preorderVal = preorder[i];

            // 查看栈顶节点（但不弹出）
            TreeNode node = stack.peek();

            // 情况1：如果栈顶节点的值不等于中序遍历当前指向的值
            // 说明当前节点应该是栈顶节点的左子节点
            // 因为中序遍历中，根节点之前是左子树，所以如果不匹配，说明还在左子树中
            if (node.val != inorder[inorderIndex]) {
                // 创建左子节点
                node.left = new TreeNode(preorderVal);
                // 将左子节点入栈，继续处理它的子树
                stack.push(node.left);
            }
            // 情况2：如果栈顶节点的值等于中序遍历当前指向的值
            // 说明栈顶节点没有左子树（或左子树已处理完）
            else {
                // 不断弹出栈顶节点，直到找到合适的父节点
                // 条件：栈非空且栈顶节点的值等于中序遍历当前值
                // 这个过程相当于回溯到还没有处理右子树的祖先节点
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    // 弹出已处理完左子树的节点
                    node = stack.pop();
                    // 中序遍历指针后移，跳过已处理的节点
                    inorderIndex++;
                }
                // 当前节点应该是最后一个弹出的节点的右子节点
                // 因为前序遍历中，在左子树之后就是右子树
                node.right = new TreeNode(preorderVal);
                // 将右子节点入栈，继续处理它的子树
                stack.push(node.right);
            }
        }

        // 返回构建好的整棵二叉树
        return root;
    }

}
