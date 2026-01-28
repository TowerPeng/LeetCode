package com.towerpeng.practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 示例 1:
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * @Author: 彭涛
 * @Date: 2026/1/27 17:04
 */
public class BuildTree106 {
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


    /**
     *
     * 需要理解思路：
     *    // 第一步 判断有效性
     *     // 第二步：后序遍历数组最后一个元素，就是当前的中间节点
     *     // 叶子节点
     *     // 第三步：找切割点
     *     // 第四步：切割中序数组，得到 中序左数组和中序右数组
     *     // 第五步：切割后序数组，得到 后序左数组和后序右数组
     *     // 第六步：递归调用
     *
     * 后序遍历：左右根
     * 中序遍历：左根右
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 如果后序遍历为空，则树为空
        if(postorder==null || postorder.length==0){
            return null;
        }
        // 后序遍历的最后一个元素是整个树的根节点
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        // 用栈来保存节点，模拟递归过程
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 中序遍历的索引，从最后开始（因为后序遍历是左右根，我们倒着来就是根右左，所以中序也从最后开始）
        int inorderIndex = inorder.length-1;
        // 从后序遍历的倒数第二个元素开始（因为倒数第一个已经是根节点了）
        for (int i = postorder.length-2; i >=0; i--) {
            // 当前后序遍历的值
            int postorderVal = postorder[i];
            // 查看栈顶节点（注意：不弹出）
            TreeNode node = stack.peek();
            // 如果栈顶节点的值不等于当前中序遍历索引的值，说明当前后序遍历的值是栈顶节点的右子节点
            // 因为中序遍历是左根右，而后序遍历倒着来是根右左，所以如果不相等，说明还在右子树
            if(node.val!=inorder[inorderIndex]){
                // 创建右子节点
                node.right = new TreeNode(postorderVal);
                // 将右子节点入栈，以便后续处理它的子树
                stack.push(node.right);
            }else{
                // 如果栈顶节点的值等于当前中序遍历索引的值，说明栈顶节点没有右子树（或者右子树已经处理完了）
                // 我们需要找到当前后序遍历的值应该作为哪个节点的左子节点
                // 通过中序遍历的顺序，我们不断弹出栈中与中序遍历匹配的节点，直到不匹配
                while(!stack.isEmpty() && stack.peek().val==inorder[inorderIndex]){
                    node = stack.pop();// 弹出匹配的节点
                    inorderIndex--; // 中序遍历索引向前移动（因为已经处理了右子树和根）
                }
                // 此时，node是最后一个弹出的节点，当前后序遍历的值应该是它的左子节点
                // 因为中序遍历中，左子节点在根节点之前，所以当我们从右子树回溯到根，再往左时，就应该是左子节点
                node.left = new TreeNode(postorderVal);
                // 将左子节点入栈，以便后续处理
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 递归
 }
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        // 1. 如果后序数组为空，说明树为空
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        // 2. 创建哈希表，存储中序遍历中每个值对应的位置
        // 就像给中序遍历的每个值贴个标签，方便快速查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);  // 值->位置
        }
        // 3. 调用递归函数来构建整棵树
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);

    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> map){
        // 4. 如果起始位置大于结束位置，说明这个子树是空的
        // 就像说："从这里到这里没有节点了"
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 5. 后序遍历的最后一个元素一定是当前子树的根节点
        // 后序：左-右-根，所以最后一个就是根
        TreeNode root = new TreeNode(postorder[postEnd]);

        // 6. 在中序遍历中找到根节点的位置
        // 中序：左-根-右，根在中间
        int inRootIndex = map.get(root.val);

        // 7. 计算左子树的大小（节点个数）
        // 根节点左边的所有节点都属于左子树
        int leftTreeSize = inRootIndex - inStart;

        // 8. 构建左子树：
        //    - 中序中：从inStart到inRootIndex-1
        //    - 后序中：从postStart开始，取leftTreeSize个节点
        root.left = buildTreeHelper(inorder, inStart, inRootIndex - 1,
                postorder, postStart, postStart + leftTreeSize - 1,
                map);

        // 9. 构建右子树：
        //    - 中序中：从inRootIndex+1到inEnd
        //    - 后序中：左子树之后的所有节点，除了最后一个（根节点）
        root.right = buildTreeHelper(inorder, inRootIndex + 1, inEnd,
                postorder, postStart + leftTreeSize, postEnd - 1,
                map);

        // 10. 返回构建好的子树根节点
        return root;
    }

}
