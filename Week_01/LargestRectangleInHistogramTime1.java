package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形 困难
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/14 20:35
 * @Version： 1.0
 */
public abstract class LargestRectangleInHistogramTime1 {

    public abstract int largestRectangleArea(int[] heights);

    public static void main(String[] args) {
        LargestRectangleInHistogramTime1 solution = new Solution2();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    // 暴力解法优化解
    // 移动双指针, 向两边扩散
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    public static class Solution1 extends LargestRectangleInHistogramTime1 {

        @Override
        public int largestRectangleArea(int[] heights) {
            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                int left = i, right = i;
                while (left > 0 && heights[left - 1] >= heights[i]) {
                    left--;
                }
                while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                    right++;
                }
                result = Math.max((right - left + 1) * heights[i], result);
            }
            return result;
        }
    }

    // 使用栈
    // 初始底 -1
    // 如果值大于 top, 则 放入
    // 如果值小于 top, 则 弹出, 并通过当前 i 作为右边界, peek(即当前弹出的下一个)作为左边界, 相减再减 1, 计算面积
    // 弹出剩余元素, 长度作为右边界, peek 作为左边界, 相减再减 1, 计算面积
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends LargestRectangleInHistogramTime1 {

        @Override
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1);
            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    result = Math.max(heights[index] * (i - stack.peek() - 1), result);
                }
                stack.push(i);
            }

            while (stack.peek() != -1) {
                int index = stack.pop();
                result = Math.max(heights[index] * (heights.length - stack.peek() - 1), result);
            }

            return result;
        }
    }
}
