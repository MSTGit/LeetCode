package com.xd;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)return  null;
        ListNode leftNode = new ListNode(0);
        ListNode rightNode = new ListNode(0);
        ListNode curLeft = leftNode;
        ListNode curRight = rightNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                curRight = curRight.next = cur;
            } else {
                curLeft = curLeft.next = cur;
            }
            cur = cur.next;
        }
        curRight.next = null;
        curLeft.next = rightNode.next;
        return leftNode.next;
    }

}

