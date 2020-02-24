package com.xd;

import java.util.Stack;

public class Implement {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return 0;
    }

    public int maxPathSum1(TreeNode root) {
        if (root == null) return 0;
        value(root);
        return sum;
    }


    int sum = Integer.MIN_VALUE;
    /*
    * 计算某个节点的最大路径和
    * 通过递归实现
    * */
    private int value(TreeNode node) {
        if (node == null) return 0;
        int leftValue = Math.max(value(node.left),0);//当前节点的左子树中路径值
        int rightValue = Math.max(value(node.right),0);//当前节点右子树路径值
        sum = Math.max(sum,node.val + leftValue + rightValue);//计算出当前节点的最大路径值
        return node.val + Math.max(leftValue,rightValue);//返回当前节点提供给父节点的最大路径值
    }
}
