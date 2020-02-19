package com.xd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return result;
    }
}
class Solution1 {
    public List<Integer> postorder(Node root) {
        return postorder(root,new ArrayList<>());
    }

    public List<Integer> postorder(Node node,List<Integer> result) {
        if (node == null) return result;
        for (int i = 0; i < node.children.size(); i++) {
            postorder(node.children.get(i),result);
        }
        result.add(node.val);
        return result;
    }
}