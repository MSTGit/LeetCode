package com.xd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Implement {
    /*
    * 使用迭代实现
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
    /*
    * 递归实现
    * */
    public List<Integer> inorderTraversal1(TreeNode root) {

        return inorderTraversal(root,new ArrayList<>());
    }
    public List<Integer> inorderTraversal(TreeNode root,List<Integer> result) {
        if (root == null) return result;
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
        return result;
    }
}
