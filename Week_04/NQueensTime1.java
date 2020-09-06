package com.index.apache.thinking.in.algorithm.day22;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 51. N皇后 困难
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/31 20:37
 * @Version： 1.0
 */
public abstract class NQueensTime1 {

    public abstract List<List<String>> solveNQueens(int n);

    public static void main(String[] args) {
        System.out.println(new Solution1().solveNQueens(8));
    }

    public static class Solution1 extends NQueensTime1 {

        List<List<String>> res = new ArrayList<>();
        int n;
        Set<Integer> cols = new LinkedHashSet<>();
        Set<Integer> pie = new LinkedHashSet<>();
        Set<Integer> na = new LinkedHashSet<>();

        @Override
        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            recursion(1);
            return res;
        }

        private void recursion(int row) {
            if (row > n) {
                generateResult(cols);
                return;
            }

            for (int col = 1; col <= n; col++) {
                if (cols.contains(col) || pie.contains(row - col) || na.contains(row + col)) {
                    continue;
                }

                cols.add(col);
                pie.add(row - col);
                na.add(row + col);

                recursion(row + 1);

                cols.remove(col);
                pie.remove(row - col);
                na.remove(row + col);
            }
        }

        private void generateResult(Set<Integer> cols) {
            List<String> s = new ArrayList<>();
            for (int col : cols) {
                StringBuilder a = new StringBuilder();
                int j = 1;
                while (j <= n) {
                    a = col == j++ ? a.append("Q") : a.append(".");
                }
                s.add(a.toString());
            }
            res.add(s);
        }

    }
}
