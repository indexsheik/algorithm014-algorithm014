package com.index.apache.thinking.in.algorithm.day20;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 中等
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/28 23:50
 * @Version： 1.0
 */
public abstract class ConstructBinaryTreeFromPreorderAndInorderTraversalTime1 {

    public abstract TreeNode buildTree(int[] preorder, int[] inorder);

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversalTime1 solution =
                new Solution1();
        TreeNode treeNode = solution.buildTree(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(1);
    }

    public static class Solution1 extends ConstructBinaryTreeFromPreorderAndInorderTraversalTime1 {

        Map<Integer, Integer> indexMap;

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) return null;
            indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return recursion(preorder, inorder,
                    0, preorder.length - 1,
                    0, preorder.length - 1);
        }

        public TreeNode recursion(int[] preorder, int[] inorder, int preorderLeft,
                                  int preorderRight, int inorderLeft, int inorderRight) {
            if (preorderLeft > preorderRight) return null;
            int nodeValue = preorder[preorderLeft];
            int inorderRoot = indexMap.get(nodeValue);
            int inorderLeftLength = inorderRoot - inorderLeft;
            TreeNode node = new TreeNode(nodeValue);
            node.left = recursion(preorder, inorder,
                    preorderLeft + 1, preorderLeft + inorderLeftLength,
                    inorderLeft, inorderRoot - 1);
            node.right = recursion(preorder, inorder,
                    preorderLeft + inorderLeftLength + 1, preorderRight,
                    inorderRoot + 1, inorderRight);
            return node;
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
