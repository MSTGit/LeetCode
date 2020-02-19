package com.xd;

import java.util.Arrays;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    //结合前序遍历与中序遍历结果构造二叉树的方法,现在将后续遍历的结果当做是中序遍历处理
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int preLen = pre.length;
        if (preLen == 0) return null;
        TreeNode node = new TreeNode(pre[0]);
        if (preLen == 1) return node;
        int postIndex = 0;
        for (int i = 0; i < preLen; i++) {
            if (post[i] == pre[1]) {
                postIndex = i + 1;
            }
        }
        int preIndex = postIndex + 1;
        node.left = constructFromPrePost(Arrays.copyOfRange(pre,1,preIndex),Arrays.copyOfRange(post,0,postIndex));
        node.right = constructFromPrePost(Arrays.copyOfRange(pre,preIndex,preLen),Arrays.copyOfRange(post,postIndex,preLen - 1));
        return node;
    }

//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        int preLength = pre.length;
//        if (preLength == 0) return null;
//        TreeNode node = new TreeNode(pre[0]);
//        if (preLength == 1) return node;
//        int index = 0;
//        for (int i = 0; i < preLength; i++) {
//            if (post[i] == pre[1]) index = i + 1;
//        }
//        node.left = constructFromPrePost(Arrays.copyOfRange(pre,1,index + 1),Arrays.copyOfRange(post,0,index));
//        node.right = constructFromPrePost(Arrays.copyOfRange(pre,index + 1,preLength),Arrays.copyOfRange(post,index,preLength - 1));
//        return node;
//    }
}

class Solution1 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        int L = 0;
        for (int i = 0; i < N; ++i)
            if (post[i] == pre[1])
                L = i+1;

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, N),
                Arrays.copyOfRange(post, L, N-1));
        return root;
    }
}

