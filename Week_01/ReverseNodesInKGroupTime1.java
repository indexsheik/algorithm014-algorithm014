package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/13 12:13
 * @since
 **/
public abstract class ReverseNodesInKGroupTime1 {

    public abstract ListNode reverseKGroup(ListNode head, int k);

    public static void main(String[] args) {
        ReverseNodesInKGroupTime1 solution = new ReverseNodesInKGroupTime1.Solution1();
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

        ListNode reverse = solution.reverseKGroup(node1, 2);
        System.out.println(reverse);
    }

    // prev   1   2   3   4   5  , k = 3, 翻转 k 个元素, 则从 head 开始到 tail 的步长为 k - 1
    // 开始 prev -> null, head -> head
    // 翻转每个部分, 返回 ListNode[3] 数组, 0 是 tail, 1 是 next , 2 是标志位, 如果为 null, 则说明该组没有进行翻转
    // 重新连接 prev.next -> tail, head.next -> next(该组进行翻转的情况下)
    // 进行下一组操作 prev -> head, head -> next
    public static class Solution1 extends ReverseNodesInKGroupTime1 {

        @Override
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k < 2) {
                return head;
            }
            ListNode mock = new ListNode(-1);
            mock.next = head;
            ListNode prev = mock;

            while (head != null) {
                ListNode[] listNodes = recursion(head, k - 1);
                if (listNodes[2] != null) {
                    prev.next = listNodes[0];
                    head.next = listNodes[1];
                }
                prev = head;
                head = listNodes[1];
            }

            return mock.next;
        }

        private ListNode[] recursion(ListNode head, int step) {
            if (step == 0) {
                return new ListNode[]{head, head.next, head};
            }
            if (head == null || head.next == null) {
                return new ListNode[]{head, null, null};
            }
            ListNode[] recursion = recursion(head.next, --step);
            if (recursion[2] == null) {
                return new ListNode[]{head, null, null};
            }
            head.next.next = head;
            head.next = null;
            return recursion;
        }
    }

    // 从 head 向前移动 k 步, 如果一直不为空, 则可以翻转, 否则不翻转, 返回 head
    // 移动后的 tail 就是下一组的 head
    // 翻转该组, 返回新的 head, 递归下一组, 将返回的 head 连接到当前已翻转后的尾部(head)
    public static class Solution2 extends ReverseNodesInKGroupTime1 {

        @Override
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }

            ListNode newHead = recursion(head, tail);

            head.next = reverseKGroup(tail, k);

            return newHead;
        }

        private ListNode recursion(ListNode head, ListNode tail) {
            ListNode prev = null;
            ListNode next = null;
            while (head != tail) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
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
                                                  