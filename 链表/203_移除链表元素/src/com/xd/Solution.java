package com.xd;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        ListNode curNode = result;//把它想象成是在组建一个新的链表
        ListNode curHead = head;
        while (curHead != null) {
            if (curHead.val != val) {
                curNode.next = curHead;
                curNode = curNode.next;
            }
            curHead = curHead.next;
        }
        curNode.next = null;
        return result.next;
    }
}

