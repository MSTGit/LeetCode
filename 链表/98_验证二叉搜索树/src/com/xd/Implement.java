package com.xd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Implement {

    /*
    * 使用中序遍历，同时判断每个节点的值，是否满足要求
    * */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();
        Queue<Integer> minQueue = new LinkedList<>();
        queue.offer(root);
        maxQueue.offer(null);
        minQueue.offer(null);
        while (!queue.isEmpty()) {//队列不为空

            //将队头出队
            TreeNode node = queue.poll();
            Integer max = maxQueue.poll();
            Integer min = minQueue.poll();
            if (min != null && node.val <= min) return false;
            if (max != null && node.val >= max) return false;
            if (node.left != null) {
                queue.offer(node.left);
                maxQueue.offer(node.val);
                minQueue.offer(min);
            }
            if (node.right != null) {
                queue.offer(node.right);
                minQueue.offer(node.val);
                maxQueue.offer(max);
            }
        }
        return true;
    }

    /*
    * 使用前序遍历，在遍历的同时，指定根节点中所有子节点的最大值与最小值
    * */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;//如果是一个空的二叉树，也是一个二叉搜索树
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,Integer min,Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        if (!isValidBST(root.left,min,root.val)) return false;//遍历左子树，左子树所有的节点，都应该小于当前的节点
        if (!isValidBST(root.right,root.val,max)) return false;//遍历右子树，右子树所有节点，都应该大于当前的节点
        return true;
    }

    /*
    * 方法二：通过中序遍历，将结果存放到栈中，依次出栈，然后进行比较
    *
    * */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;//如果是一个空的二叉树，也是一个二叉搜索树
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;//先把左边的节点全部入栈
            }
            if (stack.isEmpty())break;
            root = stack.pop();//弹出栈顶节点，如果是二叉搜索树，那么，该节点的值应该是栈中值最小的节点
            if (prevNode != null && root.val <= prevNode.val) return false;
            prevNode = root;
            root = root.right;//将右边子节点，作为根节点，继续入栈
        }
        return true;
    }

    /*
    * 方法一，通过递归中序遍历
    * */
    TreeNode prevNode;//记录上一个节点
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;//如果是一个空的二叉树，也是一个二叉搜索树
        if (!isValidBST1(root.left)) return false;
        if (prevNode !=null && root.val <= prevNode.val) return false;
        prevNode = root;
        if (!isValidBST1(root.right)) return false;
        return true;
    }
}
