package com.xd;

public class Implement {
    int maxDepth = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        //1.计算当前节点的最小高度
        minDepth(root);
        //2.计算所有节点中的最大高度
        //maxDepth;
        //3.通过最大高度，计算出最大高度层的最大宽度 ，宽度为2^(最大高度 - 1)
        int width = (int)Math.pow(2,maxDepth - 1);
        return width;
    }

    public int minDepth(TreeNode node) {
        if (node == null) return 0;
        int leftMin = minDepth(node.left);
        int rightMin = minDepth(node.right);
        if (node.left != null && node.right != null) {//存在左右子树，那么树高+ 1
            int min = Math.min(leftMin,rightMin) +1;
            maxDepth = Math.max(min,maxDepth);
            return min;
        } else { //不同时存在左右子树，那么就计算这棵子树的最大高度
            if (node.left != null) return leftMin +1;
            if (node.right != null) return rightMin + 1;
            maxDepth = 1;
            return 1;
        }
    }
}
