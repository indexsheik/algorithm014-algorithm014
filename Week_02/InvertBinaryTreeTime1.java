package com.index.apache.thinking.in.algorithm.day8;

/**
 * 226. 翻转二叉树 简单
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/17 19:54
 * @Version： 1.0
 */
public abstract class InvertBinaryTreeTime1 {

    public abstract TreeNode invertTree(TreeNode root);

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(3);
        node1.right = new TreeNode(7);
        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(9);

        InvertBinaryTreeTime1 solution = new Solution1();

        solution.invertTree(node1);

        System.out.println(1);
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(height) height为最大树高
    public static class Solution1 extends InvertBinaryTreeTime1 {

        @Override
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode l = invertTree(root.left);
            TreeNode r = invertTree(root.right);

            root.left = r;
            root.right = l;

            return root;
        }
    }

    // 广度优先搜索 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution2 extends InvertBinaryTreeTime1 {

        @Override
        public TreeNode invertTree(TreeNode root) {
            return null;
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
