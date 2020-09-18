package com.index.apache.thinking.in.algorithm.day37;

/**
 * 62. 不同路径 中等
 * <p>
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/9/16 00:12
 * @Version： 1.0
 */
public abstract class UniquePathsTime1 {

    public abstract int uniquePaths(int m, int n);

    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(3, 7));
    }

    // dp 二维数组保存
    public static class Solution1 extends UniquePathsTime1 {

        @Override
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 0;
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    // dp 一维数组保存
    public static class Solution2 extends UniquePathsTime1 {

        @Override
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
            return dp[n - 1];
        }
    }
}
