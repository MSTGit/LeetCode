package com.xd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Implement {
    /*
    * 使用链表进行优化
    * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelResult = new ArrayList<>();
        result.addFirst(levelResult);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelResult = result.get(0);
            levelResult.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--levelSize == 0 && !queue.isEmpty()) {
                levelSize = queue.size();
                levelResult = new ArrayList<>();
                result.addFirst(levelResult);
            }
        }
        return result;
    }
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelResult = new ArrayList<>();
        result.add(0,levelResult);//为当前层创建一个数组，并且将数组保存到结果数组中的第一位
        int levelSize = queue.size();//定义一个变量，保存当前层的节点数量
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelResult = result.get(0);//取出结果数组中的第0位
            levelResult.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--levelSize == 0 && !queue.isEmpty()) {//如果当前层剩余节点数量为0，说明接下来遍历的为下一层的节点元素
                levelSize = queue.size();//现在队列中保存的节点，就是下一层的全部节点，所以更新levelSize
                levelResult = new ArrayList<>();
                result.add(0,levelResult);
            }
        }
        return result;
    }
}
