package com.xd;

public class Implement {

    /*
    * 后序遍历
    * */
    TreeNode prev;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        if (prev != null) {
            root.right = prev;//将上一个遍历到的节点，作为自己的右子节点
            root.left = null;//清空是因为当前遍历到节点，左子节点就是prev，在上一步已经被right指向了，所以应该清空
        }
        prev = root;//没递归一次，都要重新赋值prev
    }

    /*
    * 前序遍历：非递归
    * */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left != null) {
                TreeNode oldRight = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode rightMost = root;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = oldRight;
            }
            root = root.right;
        }
    }
    /*
    * 前序遍历.递归
    * */
    public void flatten1(TreeNode root) {

        if (root == null) return;

        if (root.left != null) {
            TreeNode oldRight = root.right;
            root.right = root.left;//将左边的节点，移动到左边
            root.left = null;
            TreeNode rightMost = root.right;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = oldRight;
        }
        flatten1(root.right);
    }
}
