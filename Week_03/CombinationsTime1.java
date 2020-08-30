package com.index.apache.thinking.in.algorithm.day21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合 中等
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/30 21:00
 * @Version： 1.0
 */
public abstract class CombinationsTime1 {

    public abstract List<List<Integer>> combine(int n, int k);

    public static void main(String[] args) {
        System.out.println(new Solution1().combine(4, 2));
    }

    public static class Solution1 extends CombinationsTime1 {

        int k;

        int n;

        List<List<Integer>> res = new LinkedList<>();

        @Override
        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            this.n = list.size();
            recursion(list, 0, new LinkedList<>());
            return res;
        }

        public void recursion(List<Integer> list, int cursor, LinkedList<Integer> curr) {
            if (curr.size() == k) {
                res.add(new LinkedList<>(curr));
                return;
            }

            for (int i = cursor; i < n; i++) {
                curr.add(list.get(i));
                recursion(list, i + 1, curr);
                curr.removeLast();
            }
        }
    }
}
