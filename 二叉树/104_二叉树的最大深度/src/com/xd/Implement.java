package com.xd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Implement {
    /*
    * 利用层序遍历思想实现
    * */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 1;
        queue.offer(root);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--levelSize == 0 && !queue.isEmpty()) {
                levelSize = queue.size();
                result++;
            }
        }
        return result;
    }
    /*
    * 递归实现
    * */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth1(root.left);
        int rightMax = maxDepth1(root.right);
        return Math.max(leftMax,rightMax) +1;
    }
}

