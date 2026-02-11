package com.towerpeng.leetcode.link;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @Author: 彭涛
 * @Date: 2026/1/23 16:55
 */
public class RemoveNthFromEnd19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fastNode = dummyHead;
        ListNode slowNode = dummyHead;

        for(int i = 0;i<=n;i++){
            fastNode = fastNode.next;
        }

        while(fastNode!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        if(slowNode!=null){
            slowNode.next = slowNode.next.next;
        }

        return dummyHead.next;
    }


}
