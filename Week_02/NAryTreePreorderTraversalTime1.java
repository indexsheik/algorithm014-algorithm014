package com.index.apache.thinking.in.algorithm.day9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/18 22:14
 * @Version： 1.0
 */
public abstract class NAryTreePreorderTraversalTime1 {

    public abstract List<Integer> preorder(Node root);

    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2);
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children.add(n3);
        n1.children.add(n2);
        n1.children.add(n4);
        n3.children.add(n5);
        n3.children.add(n6);

        NAryTreePreorderTraversalTime1 solution = new Solution2();
        System.out.println(solution.preorder(n1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends NAryTreePreorderTraversalTime1 {

        List<Integer> list = new ArrayList<>();

        @Override
        public List<Integer> preorder(Node root) {
            recursion(root);
            return list;
        }

        public void recursion(Node node) {
            if (node == null) return;
            list.add(node.val);
            if (node.children != null) {
                for (Node n : node.children) {
                    recursion(n);
                }
            }
        }
    }

    // 迭代
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends NAryTreePreorderTraversalTime1 {

        @Override
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Deque<Node> stack = new LinkedList<>();
            Node curr = root;
            stack.push(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                list.add(curr.val);
                if (curr.children != null) {
                    for (int i = curr.children.size() - 1; i >= 0; i--) {
                        stack.push(curr.children.get(i));
                    }
                }
            }
            return list;
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
