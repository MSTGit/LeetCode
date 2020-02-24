package com.xd;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.next.val == head.val;
        //找出中间节点
        ListNode middleNode = middleNode(head);
        //翻转链表
        ListNode rightHead = reverseList(middleNode);
        ListNode leftHead = head;
        while (rightHead != null) {
            if (leftHead.val != rightHead.val) return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    /**
     * 迭代方式实现
     * */
    private ListNode reverseList1(ListNode middleNode) {
        //从中间节点的下一个节点开始翻转
        ListNode head = middleNode.next;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;//将下一个节点保存起来
            head.next = newHead;//把头节点的next指向新的头节点
            newHead = head;//更新新的头节点
            head = temp;//更新头节点
        }
        return newHead;
    }
    /**
     * 递归方式实现
     * */
    private ListNode reverseList(ListNode middleNextNode) {
        if (middleNextNode == null || middleNextNode.next == null) return middleNextNode;
        ListNode newHead = reverseList(middleNextNode.next);
        middleNextNode.next.next = middleNextNode;
        middleNextNode.next = null;
        return newHead;
    }
/**
 * 1 > 2 > 3 > 2 > 1 返回3
 * 1 > 2 > 2 > 1  返回第一个2
 * */
    private ListNode middleNode(ListNode head) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        while (fastPoint != null && !(fastPoint.next == null || fastPoint.next.next == null)) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        return slowPoint;
    }
}

