package com.xd;

public class Solution {
    /**
     * 4,1,8,4,5 5,0,1,8,4,5
     * 5,0,1,8,4,5 4,1,8,4,5
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != currentB) {
            currentA = (currentA == null) ? headB : currentA.next;
            currentB = (currentB == null) ? headA : currentB.next;
        }
        return currentA;
    }
}

