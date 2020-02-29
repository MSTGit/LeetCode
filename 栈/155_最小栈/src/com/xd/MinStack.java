package com.xd;

public class MinStack {
    /** initialize your data structure here. */
    Node head;
    public MinStack() {
        //创建一个虚拟头节点
        head = new Node(0,Integer.MAX_VALUE,null);
    }

    public void push(int x) {
        //每次创建的节点，都放在链表的最前面
        head = new Node(x,Math.min(head.minValue,x),head);//其中保存最小值是保存当前头节点中的最小值
    }

    public void pop() {
        head = head.next;//下一个节点赋值到当前节点即可
    }

    public int top() {
        return head.value;//返回当前头节点中保存的值
    }

    public int getMin() {
        return head.minValue;//返回当前头节点中保存的最小值
    }

    class Node{
        int value;
        int minValue;
        Node next;

        public Node(int value, int minValue, Node next) {
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
    }
}
