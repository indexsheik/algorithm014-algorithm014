package com.index.apache.thinking.in.algorithm.day10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/19 15:39
 * @since
 **/
public abstract class MergeKSortedListsTime1 {

    public abstract ListNode mergeKLists(ListNode[] lists);

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(4);
//        n1.next.next = new ListNode(5);
//        ListNode n2 = new ListNode(1);
//        n2.next = new ListNode(3);
//        n2.next.next = new ListNode(4);
//        ListNode n3 = new ListNode(2);
//        n3.next = new ListNode(6);
//        ListNode[] listNodes = new ListNode[]{n1, n2, n3};

        ListNode n1 = new ListNode(-2);
        n1.next = new ListNode(-1);
        n1.next.next = new ListNode(-1);
        n1.next.next.next = new ListNode(-1);
        ListNode[] listNodes = new ListNode[]{n1, null};

        MergeKSortedListsTime1 solution = new Solution2();
        ListNode listNode = solution.mergeKLists(listNodes);
        System.out.println(1);
    }

    // 分治法
    // 时间复杂度: O(logk * kn)
    // 空间复杂度: O(logk)
    public static class Solution1 extends MergeKSortedListsTime1 {

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) return lists[l];
            if (l > r) return null;
            int mid = (l + r) >> 1;
            return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        private ListNode mergeTwoList(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoList(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoList(l1, l2.next);
                return l2;
            }
        }
    }

    // 优先级队列
    // 时间复杂度: O(logk * kn)
    // 空间复杂度: O(logk)
    public static class Solution2 extends MergeKSortedListsTime1 {

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(
                    Comparator.comparingInt(o -> o.val));
            for (ListNode l : lists) {
                while (l != null) {
                    queue.add(l);
                    l = l.next;
                }
            }
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            while (!queue.isEmpty()) {
                prev.next = queue.poll();
                prev = prev.next;
                prev.next = null;
            }
            return dummy.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
                                                  