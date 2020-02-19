package com.xd;

import java.util.*;

public class Implement {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            result.addFirst(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
    /*
    * 递归实现
    * */
    public List<Integer> postorderTraversal1(TreeNode root) {
        return postorderTraversal(root,new ArrayList<>());
    }

    public List<Integer> postorderTraversal(TreeNode root,List<Integer> result) {

        if (root == null) return result;
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
        return result;
    }
}
