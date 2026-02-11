package com.towerpeng.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *
 * @Author: 彭涛
 * @Date: 2026/1/26 11:11
 */
public class MaxDepth559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            int queueSize = queue.size();
            for (int m =0;m<queueSize;m++){
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
        }
        return depth;
    }



}
