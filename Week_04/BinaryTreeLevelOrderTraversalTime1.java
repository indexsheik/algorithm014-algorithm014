package com.index.apache.thinking.in.algorithm.day23;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历 中等
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/1 15:05
 * @since
 **/
public abstract class BinaryTreeLevelOrderTraversalTime1 {

    public abstract List<List<Integer>> levelOrder(TreeNode root);

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(20);
        System.out.println(new Solution2().levelOrder(node));
    }

    // BFS
    public static class Solution1 extends BinaryTreeLevelOrderTraversalTime1 {

        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.push(root);
            while (!deque.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = deque.size();
                int i = 0;
                while (i < size) {
                    TreeNode treeNode = deque.pollFirst();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                    i++;
                }
                res.add(list);
            }
            return res;
        }
    }

    // DFS
    public static class Solution2 extends BinaryTreeLevelOrderTraversalTime1 {

        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            dfs(res, root, 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, TreeNode root, int level) {
            if (root == null) return;
            if (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            dfs(res, root.left, level + 1);
            dfs(res, root.right, level + 1);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
                                                  