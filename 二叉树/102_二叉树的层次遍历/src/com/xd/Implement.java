package com.xd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Implement {
    /*
    * 用一个变量来记录当前层的数量
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelResult = new ArrayList<>();
        result.add(levelResult);
        int levelSize = queue.size();//记录当前层的节点数量
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelResult.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            //等到当前层的节点全部出队以后，队列中剩余的数量，就是下一层的数量
            if (--levelSize == 0 && !queue.isEmpty()) {//说明已经全部出队了
                //1.更新levelSize
                levelSize = queue.size();
                //2.为下一层创建新的数组
                levelResult = new ArrayList<>();
                result.add(levelResult);
            }
        }
        return result;
    }
    /*
    * 使用两个队列，分别遍历
    * */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> firstLevelQueue = new LinkedList<>();
        Queue<TreeNode> secondLevelQueue = new LinkedList<>();
        boolean isFirstLevel = true;//标记现在最新一层的节点，是否存放在第一层
        TreeNode node = root;
        firstLevelQueue.offer(node);
        List<Integer> levelResult = new ArrayList<>();
        result.add(levelResult);
        while (!firstLevelQueue.isEmpty() || !secondLevelQueue.isEmpty()) {
            if (isFirstLevel) {//如果是存放在第一层，则从第一层中取出节点，然后放入第二层中
                node = firstLevelQueue.poll();
                levelResult = result.get(result.size() - 1);
                levelResult.add(node.val);
                if (node.left != null) secondLevelQueue.offer(node.left);
                if (node.right != null) secondLevelQueue.offer(node.right);
                //当firstLevelQueue中元素全部出队以后，开始遍历secondLevelQueue
                if (firstLevelQueue.isEmpty() && !secondLevelQueue.isEmpty()) {
                    isFirstLevel = false;
                    levelResult = new ArrayList<>();
                    result.add(levelResult);
                }
            } else {
                //从第二层中，取数据，然后放入第一层中
                node = secondLevelQueue.poll();
                levelResult = result.get(result.size() - 1);
                levelResult.add(node.val);
                if (node.left != null) firstLevelQueue.offer(node.left);
                if (node.right != null) firstLevelQueue.offer(node.right);
                if (secondLevelQueue.isEmpty() && !firstLevelQueue.isEmpty()) {
                    isFirstLevel = true;
                    levelResult = new ArrayList<>();
                    result.add(levelResult);
                }
            }
        }
        return result;
    }
}
