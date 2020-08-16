package com.index.apache.thinking.in.algorithm.homework.week1;

import com.index.apache.thinking.in.algorithm.day6.SlidingWindowMaximumTime2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值 困难
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/15 20:51
 * @Version： 1.0
 */
public abstract class SlidingWindowMaximumTime1 {

    public abstract int[] maxSlidingWindow(int[] nums, int k);

    public static void main(String[] args) {
        SlidingWindowMaximumTime1 solution = new Solution2();
        int[] result = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // 暴力
    // 对每组求一次最大值
    // 时间复杂度: O(n*k)
    // 空间复杂度: O(n-k+1)
    public static class Solution1 extends SlidingWindowMaximumTime1 {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length * k == 0) {
                return nums;
            }
            if (k == 1) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length - k + 1; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    max = Math.max(max, nums[j]);
                }
                result[i] = max;
            }

            return result;
        }
    }

    // 双端队列
    // 如果移动到的下标是 first 则删除first
    // 如果当前元素大于队列中的尾部元素, 则移除尾部元素, 也就是说 first 保持是最大的
    // 小于 first 加进去, 以便在first被移除时使用, 大于 first 的直接情空队列
    // 时间复杂度: O(n) 2*n
    // 空间复杂度: O(n) 双端队列 O(k) 数组 O(n-k+1)
    public static class Solution2 extends SlidingWindowMaximumTime1 {

        Deque<Integer> deque = new LinkedList<>();
        int[] nums;

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            this.nums = nums;

            int[] result = new int[nums.length - k + 1];
            int maxIndex = 0;
            for (int i = 0; i < k; i++) {
                cleanDeque(i, k);
                deque.addLast(i);
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            int cursor = 0;
            result[cursor++] = nums[maxIndex];

            for (int i = k; i < nums.length; i++) {
                cleanDeque(i, k);
                deque.addLast(i);
                result[cursor++] = nums[deque.getFirst()];
            }
            return result;
        }

        public void cleanDeque(int i, int k) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
        }
    }

    // 动态规划 后面学了再写 TODO
    public static class Solution3 extends SlidingWindowMaximumTime2 {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            return new int[0];
        }

    }
}
