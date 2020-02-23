package com.xd;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;//先取出当前链表中的下一个节点,保存起来
            head.next = newHead;//将当前节点的下一个节点指向新的头节点
            newHead = head;//将新的头节点指向当前头节点
            head = temp;//将当前节点指向当前前面保存的头节点的下一个接地啦
        }
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head; //把下一个节点指向当前节点
        head.next = null;
        return newHead;
    }


}

