package com.index.apache.thinking.in.algorithm.day38;

import java.util.List;

/**
 * 120. 三角形最小路径和 中等
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/9/16 21:29
 * @Version： 1.0
 */
public abstract class TriangleTime1 {

    public abstract int minimumTotal(List<List<Integer>> triangle);

    public static void main(String[] args) {

    }

    // dp bottom-up
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public static class Solution1 extends TriangleTime1 {

        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size()];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (i == triangle.size() - 1) dp[j] = triangle.get(i).get(j);
                    else dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }

    // 递归
    // 时间复杂度: O(2^n)
    // 空间复杂度: O(m) m 为高度
    public static class Solution2 extends TriangleTime1 {

        int row;

        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            row = triangle.size();
            return recursion(0, 0, triangle);
        }

        private int recursion(int level, int col, List<List<Integer>> triangle) {
            if (level == row - 1) {
                return triangle.get(level).get(col);
            }
            int left = recursion(level + 1, col, triangle);
            int right = recursion(level + 1, col + 1, triangle);
            return Math.min(left, right) + triangle.get(level).get(col);
        }
    }
}
