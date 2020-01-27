package com.xd;

import java.util.List;
import java.util.Queue;

public class Implement {
    /*
    * 优化计算
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int next = 0;
        ListNode prevNode = result;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                val = l1.val + next;
                l1 = l1.next;
            } else {
                val = l2.val + next;
                l2 = l2.next;
            }
            ListNode node = new ListNode(val % 10);
            prevNode = prevNode.next = node;
            if (val >= 10) {
                next = val / 10;
            } else  {
                next = 0;
            }
            System.out.println(node.val);
        }
        if (next != 0) {
            ListNode node = new ListNode(next);
            prevNode = prevNode.next = node;
        }
        return result.next;
    }
    /*
    * 遍历节点的同时，就计算出当前节点的结果，这样可以保证计算的结果不会溢出
    * */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        ListNode prevNode = result;
        while (curL1 != null || curL2 != null) {
            int val = 0;
            if (curL1 != null && curL2 != null) {
                val = curL1.val + curL2.val;
                curL1 = curL1.next;
                curL2 = curL2.next;
            } else if (curL1 != null && curL2 == null) {
                val = curL1.val;
                curL1 = curL1.next;
            } else {
                val = curL2.val;
                curL2 = curL2.next;
            }
            if (prevNode.next != null) {
                val += prevNode.next.val;
            }
            ListNode node = new ListNode(val % 10);
            if (val >= 10) {
                ListNode nextNode = new ListNode(val / 10);
                node.next = nextNode;
            }
            prevNode = prevNode.next = node;
            System.out.println(node.val);
        }
        return result.next;
    }
    /*
    * 存在的问题：对于节点过多的情况，回到导致内存溢出
    * */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        long addResult = 0;
        int index = 0;
        while (curL1 != null || curL2 != null) {
            long val = 0;
            if (curL1 != null && curL2 != null) {
                val = curL1.val + curL2.val;
                curL1 = curL1.next;
                curL2 = curL2.next;
            } else if (curL1 != null && curL2 == null) {
                val = curL1.val;
                curL1 = curL1.next;
            } else {
                val = curL2.val;
                curL2 = curL2.next;
            }

            addResult = addResult + (long)Math.pow(10,index) * val;
            System.out.println(addResult);
            index++;
        }

//        System.out.println(addResult);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        if (addResult == 0) {
            return result;
        }
        while (addResult >= 1) {
            int curResult = (int)addResult % 10;
            //System.out.println(curResult);
            ListNode curNode = new ListNode(curResult);
            cur = cur.next = curNode;
            addResult /= 10;
        }
        return result.next;
    }
}
