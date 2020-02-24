package com.xd;

public class Solution {
    public void deleteNode(ListNode node) {
        //当前传入的节点,就是要删除的节点,由于是单向链表,所以无法获取到整个链表的头头节点
        //所以,传入节点的值,就用下一个节点的值来覆盖
        //由于节点的值是唯一的,所以只可能删除一个节点
        ListNode prevNode = null;
        ListNode curNode = node;
        ListNode nextNode = curNode.next;
        Boolean isFind = false;
        while (true) {
            if (nextNode == null) break;
            curNode.val = nextNode.val;
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        if(prevNode != null) {
            prevNode.next = null;
        }
    }

    //更简单的解法
    public void deleteNode1(ListNode node) {
        node.val=node.next.val;//先把当前节点的值修改为下一个节点的值,那当前节点就变为了下一个节点
        node.next=node.next.next;//再将下一个节点删掉即可
    }

}
/**
 * [4,5,1,9]
 * 4
 *
 * */
