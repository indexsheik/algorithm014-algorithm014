package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/12 15:00
 * @since
 **/
public abstract class SwapNodesInPairsTime1 {

    public abstract ListNode swapPairs(ListNode head);

    public static void main(String[] args) {
        SwapNodesInPairsTime1 solution = new SwapNodesInPairsTime1.Solution2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode reverse = solution.swapPairs(node1);
        System.out.println(reverse);
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 两个一组, 每次递归传入 second 的下一节点, solution 方法传回 second, 因为翻转后 second 是上一组的下一个元素, 需要进行关联
    public static class Solution1 extends SwapNodesInPairsTime1 {

        @Override
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = head.next;

            ListNode last = swapPairs(second.next);

            first.next = last;
            second.next = first;

            return second;
        }
    }

    // 迭代
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 在开始预设一个虚拟节点, 并缓存每一组的尾节点给下一组使用
    public static class Solution2 extends SwapNodesInPairsTime1 {

        @Override
        public ListNode swapPairs(ListNode head) {
            ListNode mock = new ListNode(-1);
            mock.next = head;

            ListNode prev = mock;

            while (head != null && head.next != null) {
                ListNode first = head;
                ListNode second = head.next;

                first.next = second.next;
                prev.next = second;
                second.next = first;

                head = first.next;
                prev = first;
            }

            return mock.next;
        }
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
                                                  