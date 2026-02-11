package com.towerpeng.leetcode.link;

/**
 * 设计链表
 * （需要注意get是从实际节点开始(head.next)而不是head）
 * @Author: 彭涛
 * @Date: 2026/1/23 16:13
 */
public class MyLinkedList707 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            val = this.val;
        }
    }
    int size;
    ListNode head;

    public MyLinkedList707() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if(index>=size || index<0){
            return -1;
        }
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index<0){
            index = 0;
        }
        if(index>size){
            return;
        }
        ListNode cur = head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=size){
            return;
        }
        if(index<0){
            return;
        }
        ListNode cur = head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }


}
