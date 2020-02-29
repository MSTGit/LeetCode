package com.xd;

public class Main {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(6);
        ms.push(9);
        ms.push(8);
        ms.push(5);
        ms.push(2);
        ms.push(7);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());

    }
}
