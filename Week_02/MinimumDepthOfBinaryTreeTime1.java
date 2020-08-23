package com.index.apache.thinking.in.algorithm.day8;

/**
 * 111. 二叉树的最小深度 简单
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/17 20:20
 * @Version： 1.0
 */
public abstract class MinimumDepthOfBinaryTreeTime1 {

    public abstract int minDepth(TreeNode root);

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);

        MinimumDepthOfBinaryTreeTime1 solution = new Solution1();

        System.out.println(solution.minDepth(node1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(height) height为最大树高
    public static class Solution1 extends MinimumDepthOfBinaryTreeTime1 {

        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if(root.left == null && root.right == null){
                return 1;
            }
            int min = Integer.MAX_VALUE;
            if (root.left != null) {
                min =  Math.min(min, minDepth(root.left));
            }

            if (root.right != null) {
                min =  Math.min(min, minDepth(root.right));
            }

            return min + 1;
        }
    }

    // 深度优先搜索 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution2 extends MinimumDepthOfBinaryTreeTime1 {

        @Override
        public int minDepth(TreeNode root) {
            return 0;
        }
    }

    // 广度优先搜索 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution3 extends MinimumDepthOfBinaryTreeTime1 {

        @Override
        public int minDepth(TreeNode root) {
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
