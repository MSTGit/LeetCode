package com.xd;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode curDummy = dummy;
        ListNode cur = head;
        int listLength = 0;
        while (cur != null) {
            listLength++;
            cur = cur.next;
        }
        cur = head;
        int rotateLength = k % listLength;//计算最终旋转的次数
        int headerIndex = listLength - rotateLength;
        while (headerIndex != 0) {//找到要旋转的头节点
            headerIndex--;
            curDummy = curDummy.next = cur;
            cur = cur.next;
        }
        //将头拼接上去。
        if (cur != null) {
            ListNode temp = dummy.next;
            dummy.next = cur;
            while ( cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
        //将dummy为节点的next清空
        curDummy.next = null;
        return dummy.next;
    }
}

