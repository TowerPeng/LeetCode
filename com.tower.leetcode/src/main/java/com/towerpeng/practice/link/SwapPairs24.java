package com.towerpeng.practice.link;

/**
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 * @Author: 彭涛
 * @Date: 2026/1/23 16:51
 */
public class SwapPairs24 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {

        //使用临时节点存储
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curr = dummyHead;

        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;

        while(curr.next!=null && curr.next.next!=null){
            temp = curr.next.next.next;
            firstNode = curr.next;
            secondNode = curr.next.next;

            curr.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;

            curr = firstNode;
        }
        return dummyHead.next;
    }
}
