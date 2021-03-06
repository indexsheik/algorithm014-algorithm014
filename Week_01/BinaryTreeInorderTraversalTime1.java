package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/16 17:28
 * @since
 **/
public abstract class BinaryTreeInorderTraversalTime1 {

    public abstract List<Integer> inorderTraversal(TreeNode root);

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        BinaryTreeInorderTraversalTime1 solution = new Solution1();

        System.out.println(solution.inorderTraversal(node1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(log n)
    public static class Solution1 extends BinaryTreeInorderTraversalTime1 {

        List<Integer> list = new ArrayList<>();

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            recursion(root);
            return list;
        }

        public void recursion(TreeNode root) {
            if (root == null) return;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
    }

    // 遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends BinaryTreeInorderTraversalTime1 {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode curr = root;
            boolean flag = true;
            while (curr != null) {
                if (curr.left != null && flag) {
                    stack.push(curr);
                    curr = curr.left;
                    continue;
                }
                list.add(curr.val);
                if (curr.right != null) {
                    curr = curr.right;
                    flag = true;
                    continue;
                }
                if (!stack.isEmpty()) {
                    curr = stack.pop();
                    flag = false;
                }
            }
            return list;
        }
    }

    // 遍历优化
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution3 extends BinaryTreeInorderTraversalTime1 {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
            return list;
        }
    }

    // 莫里斯遍历 TODO
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution4 extends BinaryTreeInorderTraversalTime1 {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            return list;
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
                                                  