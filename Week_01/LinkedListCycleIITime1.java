package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/12 21:02
 * @Version： 1.0
 */
public abstract class LinkedListCycleIITime1 {

    public abstract ListNode detectCycle(ListNode head);

    public static void main(String[] args) {
        LinkedListCycleIITime1 solution = new LinkedListCycleIITime1.Solution2();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(solution.detectCycle(node1));
    }

    // 暴力
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 使用 Set 保存出现过的节点
    public static class Solution1 extends LinkedListCycleIITime1 {

        @Override
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                } else {
                    set.add(head);
                    head = head.next;
                }
            }
            return null;
        }
    }

    // 快慢指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 设 非环链长为 a, 环链长 b
    // fast 步长为 2, slow 步长为 1 , 则 f = 2s
    // 如果能相遇, f 比 s 多走了整数 n 被的 b, 则 f = s + nb
    // ∴ s = nb , f = 2nb
    // 每一次走到入口的步数是 a + nb
    // 所以再让 s 走 a 步即可到达入口,
    // 只需要另一个指针从 head 走 a 步, 即可与 s 在入口相遇
    public static class Solution2 extends LinkedListCycleIITime1 {

        @Override
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    break;
                }
            }

            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
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
