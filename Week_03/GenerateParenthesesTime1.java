package com.index.apache.thinking.in.algorithm.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 中等
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/26 20:23
 * @Version： 1.0
 */
public abstract class GenerateParenthesesTime1 {

    public abstract List<String> generateParenthesis(int n);

    public static void main(String[] args) {
        GenerateParenthesesTime1 solution = new Solution1();
        System.out.println(solution.generateParenthesis(3));
    }

    // 递归
    // 时间复杂度: O(2^n)
    // 空间复杂度: O(n)
    public static class Solution1 extends GenerateParenthesesTime1 {

        List<String> list = new ArrayList<>();

        @Override
        public List<String> generateParenthesis(int n) {
            generate(0, 0, n, "");
            return list;
        }

        private void generate(int left, int right, int n, String s) {
            if (left == n && right == n) {
                list.add(s);
                return;
            }
            if (left < n) generate(left + 1, right, n, s + "(");
            if (right < left) generate(left, right + 1, n, s + ")");
        }
    }
}
