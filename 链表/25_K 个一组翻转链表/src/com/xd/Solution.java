package com.xd;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k)  {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode curDummy = dummy;
        while (cur != null && cur.next != null) {
            ListNode nextCur = cur;
            int i = k;
            while (i != 0 && nextCur != null) {
                i--;
                nextCur = nextCur.next;
            }
            if (i != 0) {//判断当前的节点是否足够一组节点进行翻转，如果够，就进行翻转，不够就将剩余的节点，直接接到当前的节点后面
                curDummy.next = cur;
                cur = null;

                break;
            }
            curDummy.next = revert(cur,k);
            while (curDummy.next != null) {
                curDummy = curDummy.next;
            }
            cur = nextCur;
        }
        while (curDummy.next != null) {
            curDummy = curDummy.next;
        }
        curDummy.next = cur;
        return dummy.next;
    }

    ListNode revert(ListNode node,int k) {//将k个一组的节点，进行翻转
        ListNode newHead = null;
        while (k != 0) {
            k--;
            ListNode temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }
}

