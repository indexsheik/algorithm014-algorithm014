package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/12 21:02
 * @Version： 1.0
 */
public abstract class LinkedListCycleTime1 {

    public abstract boolean hasCycle(ListNode head);

    public static void main(String[] args) {
        LinkedListCycleTime1 solution = new LinkedListCycleTime1.Solution3();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(solution.hasCycle(node1));
    }

    // 暴力
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 使用 Set 保存出现过的节点
    public static class Solution1 extends LinkedListCycleTime1 {

        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            Set<ListNode> set = new HashSet<>();
            ListNode curr = head;
            while (curr != null) {
                if (set.contains(curr)) {
                    return true;
                } else {
                    set.add(curr);
                    curr = curr.next;
                }
            }
            return false;
        }
    }

    // 快慢指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 快指针步长 2, 慢指针步长 1, 如果引用对象相同则证明有环
    public static class Solution2 extends LinkedListCycleTime1 {

        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;

            while (true) {
                if (fast.next == null || fast.next.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    return true;
                }
            }
        }
    }

    // 异常版快慢指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution3 extends LinkedListCycleTime1 {

        @Override
        public boolean hasCycle(ListNode head) {
            try {
                ListNode fast = head.next;
                ListNode slow = head;

                while (fast != slow) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
