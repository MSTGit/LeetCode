package com.xd;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = head;
        return second;
    }
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode curDummy = dummy;
        while (cur != null && cur.next != null) {
            curDummy = curDummy.next = cur = swap(cur);
            curDummy = curDummy.next;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    ListNode swap(ListNode node) {
        ListNode temp = node.next.next;
        node.next.next = node;
        node = node.next;
        node.next.next = temp;
        return node;
    }

}

