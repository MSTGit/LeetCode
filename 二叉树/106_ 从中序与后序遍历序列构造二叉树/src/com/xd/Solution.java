package com.xd;

import java.util.ArrayList;
import java.util.HashMap;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*
* 中序遍历 inorder = [9,3,15,20,7]
* 后序遍历 postorder = [9,15,7,20,3]
* 头节点为 3 -> 中序遍历中,左子树元素顺序为 9,中序遍历中,右子树元素顺序为15,20,7 ,后序遍历中,左子树元素顺序为9,后续遍历中,右子树元素顺序为15,7,20
* 左头节点为9 右头节点 20 左15 右 7
* */
class Solution {
    int postIndex;//根节点的位置
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        int valIndex = 0;
        for (Integer val : inorder) indexMap.put(val,valIndex++);//将中序遍历结果的元素进行编号
        return helper(0,postorder.length - 1);
    }

    public TreeNode helper(int leftIndex, int rightIndex) {
        if (rightIndex < leftIndex) return null;//说明索引不合理
        int rootVal = postorder[postIndex];//取到当前节点的根节点
        TreeNode node = new TreeNode(rootVal);
        //计算边界
        int index = indexMap.get(rootVal);
        postIndex--;//由于是后续遍历,需要先得到右边的节点
        node.right = helper(index + 1 ,rightIndex);
        node.left = helper(leftIndex, index - 1);
        return node;
    }
}

