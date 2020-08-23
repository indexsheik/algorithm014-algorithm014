package com.index.apache.thinking.in.algorithm.day9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/18 19:52
 * @Version： 1.0
 */
public abstract class NAryTreePostorderTraversalTime1 {

    public abstract List<Integer> postorder(Node root);

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

        NAryTreePostorderTraversalTime1 solution = new Solution2();
        System.out.println(solution.postorder(n1));
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends NAryTreePostorderTraversalTime1 {

        List<Integer> list = new ArrayList<>();

        @Override
        public List<Integer> postorder(Node root) {
            recursion(root);
            return list;
        }

        public void recursion(Node node) {
            if (node == null) return;
            if (node.children != null) {
                for (Node n : node.children) {
                    recursion(n);
                }
            }
            list.add(node.val);
        }
    }

    // 迭代
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends NAryTreePostorderTraversalTime1 {

        @Override
        public List<Integer> postorder(Node root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Deque<Node> stack = new LinkedList<>();
            Node curr = root;
            stack.push(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                list.addFirst(curr.val);
                List<Node> children = curr.children;
                if (children != null) {
                    for (int i = 0; i < children.size(); i++) {
                        if (children.get(i) != null) {
                            stack.push(children.get(i));
                        }
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

    ;
}
