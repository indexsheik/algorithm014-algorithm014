package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 206. 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/12 11:47
 * @since
 **/
public abstract class ReverseLinkedListTime1 {

    public abstract ListNode reverseList(ListNode head);

    public static void main(String[] args) {
        ReverseLinkedListTime1 solution = new ReverseLinkedListTime1.Solution2();
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

        ListNode reverse = solution.reverseList(node1);
        System.out.println(reverse);
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n), 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
    public static class Solution1 extends ReverseLinkedListTime1 {

        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }

    // 循环
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution2 extends ReverseLinkedListTime1 {

        @Override
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
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
                                                  