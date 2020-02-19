package com.xd;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
//迭代方式实现
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();//把最后一个取出来,因为最后一个需要最先访问
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));//从后往前将节点放入,这样要访问的节点就会最先出栈
            }
        }
        return result;
    }
}
//class Solution {
//    public List<Integer> preorder(Node root) {
//        LinkedList<Node> stack = new LinkedList<>();
//        LinkedList<Integer> output = new LinkedList<>();
//        if (root == null) {
//            return output;
//        }
//
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            Node node = stack.pollLast();
//            output.add(node.val);
//            Collections.reverse(node.children);
//            for (Node item : node.children) {
//                stack.add(item);
//            }
//        }
//        return output;
//    }
//}


//递归方式实现
class Solution1 {
    public List<Integer> preorder(Node root) {
        return preorder(root,new ArrayList<>());
    }

    public List<Integer> preorder(Node node,List<Integer> result) {
        if (node == null) return result;
        result.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            Node childNode = node.children.get(i);
            if (childNode != null) {
                preorder(childNode,result);
            }
        }
        return result;
    }
}
