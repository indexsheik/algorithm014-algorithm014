package com.index.apache.thinking.in.algorithm.day9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1021. 删除最外层的括号
 * <p>
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/18 13:29
 * @since
 **/
public abstract class RemoveOutermostParenthesesTime1 {

    public abstract String removeOuterParentheses(String S);

    public static void main(String[] args) {
        RemoveOutermostParenthesesTime1 solution = new Solution1();
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }

    // 记录左右个数判断是否匹配
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution1 extends RemoveOutermostParenthesesTime1 {

        @Override
        public String removeOuterParentheses(String S) {
            int left = 0, right = 0;
            boolean begin = false;
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (!begin) {
                    begin = true;
                    continue;
                }
                if (S.charAt(i) == '(') {
                    left++;
                    a.append('(');
                } else {
                    if (left == right) {
                        begin = false;
                    } else {
                        right++;
                        a.append(')');
                    }
                }
            }
            return a.toString();
        }
    }
}
                                                  