package com.index.apache.thinking.in.algorithm.day38;

/**
 * 63. 不同路径 II 中等
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/16 16:21
 * @since
 **/
public abstract class UniquePathsIITime1 {

    public abstract int uniquePathsWithObstacles(int[][] obstacleGrid);

    public static class Solution1 extends UniquePathsIITime1 {

        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[] dp = new int[n];
            dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                        continue;
                    }
                    if (j > 0) {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
                                                  