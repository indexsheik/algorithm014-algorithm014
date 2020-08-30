package com.index.apache.thinking.in.algorithm.day18;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 98. 验证二叉搜索树 中等
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/26 21:07
 * @Version： 1.0
 */
public abstract class ValidateBinarySearchTreeTime1 {

    public abstract boolean isValidBST(TreeNode root);

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(20);
        ValidateBinarySearchTreeTime1 solution = new Solution1();
        System.out.println(solution.isValidBST(node));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends ValidateBinarySearchTreeTime1 {

        @Override
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer lower, Integer upper) {
            if (root == null) return true;
            if (lower != null && root.val <= lower) return false;
            if (upper != null && root.val >= upper) return false;
            if (!helper(root.left, lower, root.val)) return false;
            if (!helper(root.right, root.val, upper)) return false;
            return true;
        }

    }

    // 中序遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends ValidateBinarySearchTreeTime1 {

        @Override
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return true;
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
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
