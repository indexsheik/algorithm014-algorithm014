package com.index.apache.thinking.in.algorithm.day36;

/**
 * 64. 最小路径和 中等
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/14 12:31
 * @since
 **/
public abstract class MinimumPathSumTime1 {

    public abstract int minPathSum(int[][] grid);

    public static void main(String[] args) {

    }

    public static class Solution1 extends MinimumPathSumTime1 {

        @Override
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            if (m == 1 && n == 0) return 0;
            int[][] tmp = new int[m][n];
            tmp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                tmp[i][0] = tmp[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                tmp[0][j] = tmp[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    tmp[i][j] = Math.min(tmp[i - 1][j], tmp[i][j - 1]) + grid[i][j];
                }
            }
            return tmp[m - 1][n - 1];
        }
    }
}
                                                  