package com.xd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Implement {

    /*
    * 使用迭代的方式实现
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return result;
    }

    /*
    * 使用递归的方式实现
    * */
    public List<Integer> preorderTraversal1(TreeNode root) {
        return preorderTraversal(root,new ArrayList<>());
    }

    public List<Integer> preorderTraversal(TreeNode root,List<Integer> result ) {
        if (root == null) return result;
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
        return result;
    }
}
