package com.xd;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);//如果这个二叉树是对称的,那么左右节点的值应该相等
    }
    public boolean isSymmetric(TreeNode node1,TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;//因为前面已经判断了两个同时为空的情况,如果还有一个节点的值是空,则说明一定不对称
        return (node1.val == node2.val) && isSymmetric(node1.left,node2.right) && isSymmetric(node1.right,node2.left);
    }
}
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //1.使用层序遍历
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        LinkedList<TreeNode> resultList = new LinkedList<>();
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            resultList.add(node.left);
            resultList.add(node.right);
            if (--levelSize == 0 && !queue.isEmpty()) {//说明到了新的一层了
                levelSize = queue.size();//更新当前层的大小
                while (!resultList.isEmpty()) {
                    TreeNode firstNode = resultList.removeFirst();
                    TreeNode lastNode = resultList.removeLast();
                    if ((firstNode == null && lastNode !=null) || (firstNode != null && lastNode ==null)) return false;
                    if (firstNode == null && lastNode == null) continue;
                    if (firstNode.val != lastNode.val) return false;
                }
            }
        }
        return true;
    }
}
