package com.index.apache.thinking.in.algorithm.day23;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值 中等
 * <p>
 * <p>
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 *
 * @author xiaoxuezhi
 * @date 2020/9/1 16:48
 * @since
 **/
public abstract class FindLargestValueInEachTreeRowTime1 {

    public abstract List<Integer> largestValues(TreeNode root);


    public static void main(String[] args) {

    }

    public static class Solution1 extends FindLargestValueInEachTreeRowTime1 {

        @Override
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int size = deque.size(), i = 0;
                while (i++ < size) {
                    root = deque.pollFirst();
                    max = Math.max(max, root.val);
                    if (root.left != null) deque.addLast(root.left);
                    if (root.right != null) deque.addLast(root.right);
                }
                res.add(max);
            }
            return res;
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
                                                  