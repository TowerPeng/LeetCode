package com.towerpeng.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * @Author: 彭涛
 * @Date: 2026/1/26 9:23
 */
public class Connect116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            // 当前节点，第一层处理
            int size = queue.size();
            Node cur = queue.poll();
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
            for(int i = 1;i<size;i++){
                Node next = queue.poll();
                if(next.left!=null){
                    queue.add(next.left);
                }
                if(next.right!=null){
                    queue.add(next.right);
                }
                cur.next = next;
                cur = next;
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root != null) {
            connect(root.left, root.right);
        }
        return root;
    }

    public void connect(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        if (left.left != null) {
            connect(left.left, left.right);
            connect(left.right, right.left);
            connect(right.left, right.right);
        }
    }
}
