package com.index.apache.thinking.in.algorithm.day8;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/17 16:47
 * @since
 **/
public abstract class BinaryTreePostorderTraversalTime1 {

    public abstract List<Integer> postorderTraversal(TreeNode root);

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        BinaryTreePostorderTraversalTime1 solution = new Solution2();

        System.out.println(solution.postorderTraversal(node1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(log n)
    public static class Solution1 extends BinaryTreePostorderTraversalTime1 {

        List<Integer> list = new ArrayList<>();

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            recursion(root);
            return list;
        }

        public void recursion(TreeNode root) {
            if (root == null) return;
            recursion(root.left);
            recursion(root.right);
            list.add(root.val);
        }
    }

    // 遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends BinaryTreePostorderTraversalTime1 {

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode curr = root;
            stack.push(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                list.addFirst(curr.val);
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
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
                                                  