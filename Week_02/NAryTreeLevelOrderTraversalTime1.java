package com.index.apache.thinking.in.algorithm.day10;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/19 20:26
 * @Version： 1.0
 */
public abstract class NAryTreeLevelOrderTraversalTime1 {

    public abstract List<List<Integer>> levelOrder(Node root);

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

        NAryTreeLevelOrderTraversalTime1 solution = new Solution1();
        System.out.println(solution.levelOrder(n1));
    }

    // 广度优先搜索
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends NAryTreeLevelOrderTraversalTime1 {

        @Override
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            Deque<Node> deque = new LinkedList<>();
            deque.push(root);
            Node n = null;
            while (!deque.isEmpty()) {
                List<Integer> line = new ArrayList<>();
                Deque<Node> tmp = new LinkedList<>();
                while (!deque.isEmpty()) {
                    n = deque.pop();
                    line.add(n.val);
                    tmp.addAll(Optional.ofNullable(n.children).orElseGet(ArrayList::new));
                }
                result.add(line);
                deque = tmp;
            }
            return result;
        }
    }

    // 广度优先搜索
    // 时间复杂度: O(n)
    // 空间复杂度: O(logn)
    public static class Solution2 extends NAryTreeLevelOrderTraversalTime1 {

        List<List<Integer>> result = new ArrayList<>();

        @Override
        public List<List<Integer>> levelOrder(Node root) {
            if (root != null) {
                recursion(root, 0);
            }
            return result;
        }

        private void recursion(Node node, int level) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            if(node.children !=null){
                for (Node n : node.children) {
                    recursion(n, level + 1);
                }
            }
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
