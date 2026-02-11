package com.towerpeng.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个二叉树：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * @Author: 彭涛
 * @Date: 2026/1/26 9:23
 */
public class Connect117 {

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
            Node node = null;
            Node preNode = null;

            for(int i = 0;i<size;i++){
                if(i==0){
                    preNode = queue.poll();
                    node = preNode;
                }else{
                    node = queue.poll();
                    preNode.next = node;
                    preNode = preNode.next;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            node.next = null;
        }
        return root;
    }

    public Node connect2(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            Node pre = q.poll();
            Node nxt = new Node();
            while (--n > 0){
                if (pre.left != null) q.offer(pre.left);
                if (pre.right != null) q.offer(pre.right);
                nxt = q.poll();
                pre.next = nxt;
                pre = nxt;
            }
            if (pre.left != null) q.offer(pre.left);
            if (pre.right != null) q.offer(pre.right);
            pre.next = null;
        }
        return root;
    }
}
