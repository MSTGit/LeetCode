package com.xd;

public class Solution {
    //使用双指针实现
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode curDummy = dummy;
        //定义两个指针，一个指针在前面，一个指针在后面
        ListNode frontNode = head;
        ListNode behindNode = head;
        //把前面的指针，先移动到前面，保持与后面指针有n的间距
        for (int i = 0; i < n - 1; i++) {
            frontNode = frontNode.next;
        }
        //同时移动两个指针，直到前面的指针为0
        while (frontNode != null) {
            if (frontNode.next != null) {
                curDummy = curDummy.next = behindNode;
            }
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }
        curDummy.next = null;
        while (behindNode != null) {
            curDummy = curDummy.next = behindNode;
            behindNode = behindNode.next;
        }
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if (head == null) return null;
        ListNode curNode = head;
        int headLength = 0;
        while (curNode != null) {//计算链表长度
            headLength++;
            curNode = curNode.next;
        }
        ListNode reslut = new ListNode(0);
        ListNode curResult = reslut;
        curNode = head;
        for (int i = 0; i < headLength - n; i++) {//组装链表
            curResult = curResult.next = curNode;
            curNode = curNode.next;
        }
        curResult.next = null;
        //到这里，curNode就是应该被删除的节点
        curNode = curNode.next;
        while (curNode != null) {
            curResult = curResult.next = curNode;
            curNode = curNode.next;
        }

        return reslut.next;
    }
}

