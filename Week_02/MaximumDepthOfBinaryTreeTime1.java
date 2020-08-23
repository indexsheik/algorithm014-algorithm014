package com.index.apache.thinking.in.algorithm.day8;

/**
 * 104. 二叉树的最大深度 简单
 * <p>
 * <p>
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/17 19:44
 * @Version： 1.0
 */
public abstract class MaximumDepthOfBinaryTreeTime1 {

    public abstract int maxDepth(TreeNode root);

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTreeTime1 solution = new Solution1();

        System.out.println(solution.maxDepth(node1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(height) height为最大树高
    public static class Solution1 extends MaximumDepthOfBinaryTreeTime1 {

        @Override
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    // 广度优先搜索 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution2 extends MaximumDepthOfBinaryTreeTime1 {

        @Override
        public int maxDepth(TreeNode root) {
            return 0;
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
