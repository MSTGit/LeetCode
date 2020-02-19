package com.xd;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < node.children.size(); i++) {
                queue.offer(node.children.get(i));
            }
            if (--levelSize == 0 && !queue.isEmpty()) {//现在节点中存放的是新的一层节点
                levelSize = queue.size();
                depth++;
            }
        }
        return depth;
    }
}
class Solution1 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int depth = maxDepth(root.children.get(i));
            maxDepth = Math.max(maxDepth,depth);
        }
        return maxDepth +1;
    }
}
