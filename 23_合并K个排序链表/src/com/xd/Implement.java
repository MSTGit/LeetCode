package com.xd;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Implement {

    /*
    *  1 2 3
    *  1   3 step == 1,nextStep == 2
    *  1     step == 2,nextStep == 4;
    * */
    //实现方法五：使用分治策略
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int step = 1;
        while (step < lists.length) {
            int nextStep = step << 1;
            for (int i = 0; i + step < lists.length; i += nextStep) {
                if (lists[i] == null) continue;
                    lists[i] = mergeTwoLists1(lists[i],lists[i + step]);
            }
            step = nextStep;
        }
        return lists[0];
    }

    //实现方式四：堆排序，每次获取当前链表中的最小头节点
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        //小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode l1,ListNode l2)->{
            return l1.val - l2.val;
        });
        //将所有的链表入队
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            //取出队列中的头元素，即为当前所有队列中，值最小的头节点
            ListNode node = queue.poll();
            if (node.next != null) {
                //取出后，将当前链表的下一个节点继续入队
                queue.offer(node.next);
            }
            cur = cur.next = node;
        }

        return result.next;
    }

    //实现方式三：逐一进行两两合并，将合并后的结果，合并到第一个链表中
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists1(lists[0],lists[i]);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur = cur.next = l2;
                l2 = l2.next;
            } else {
                cur = cur.next = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return result.next;
    }
    //实现方式二：逐一比较,比较每一个链表中的头节点，获取到当前所有链表中的做小头节点，保存以后，更新头节点
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (minIndex == -1 || lists[minIndex].val > lists[i].val) {
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            cur = cur.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
        }
        return result.next;
    }
    //实现方式一：使用最普通的方式
    public ListNode mergeKLists1(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                list.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        list.sort((ListNode l1,ListNode l2)->{
            return l1.val - l2.val;
        });
        ListNode result = new ListNode(0);
        ListNode cur = result;
        for (int i = 0; i < list.size(); i++) {
            cur = cur.next = list.get(i);
        }
        return cur.next;
    }
}
