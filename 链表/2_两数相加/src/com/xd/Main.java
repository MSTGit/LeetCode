package com.xd;

public class Main {
    public static void main(String[] args) {
        new Implement().addTwoNumbers(createL1(),createL2());
    }

    public static ListNode createL1() {
        int[] nums = {9};
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        for (int i = 0; i < nums.length; i++) {
            ListNode curNode = new ListNode(nums[i]);
            cur = cur.next = curNode;
        }
        return l1.next;
    }

    public static ListNode createL2() {
        int[] nums = {1,9,9,9,9,9,9,9,9,9};
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        for (int i = 0; i < nums.length; i++) {
            ListNode curNode = new ListNode(nums[i]);
            cur = cur.next = curNode;
        }
        return l1.next;
    }
}
