package com.xd;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        int index = 0;
        for (Integer val : inorder) indexMap.put(val,index++);
        return helper(indexMap,0,index--,preorder,inorder);
    }

    public TreeNode helper(HashMap<Integer,Integer> indexMap,int leftIndex,int rightIndex,int[] preorder, int[] inorder) {
        if (leftIndex > rightIndex || preIndex >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[preIndex]);//创建一个节点
        preIndex++;
        //获取节点中的值,在中序遍历中的位置
        int index = indexMap.get(node.val);
        //index 左边的是左边的节点
        node.left = helper(indexMap,leftIndex,index - 1,preorder,inorder);
        node.right = helper(indexMap,index + 1, rightIndex,preorder,inorder);
        return node;
    }
}
