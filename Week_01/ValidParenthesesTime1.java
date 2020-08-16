package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/13 16:00
 * @since
 **/
public abstract class ValidParenthesesTime1 {

    public abstract boolean isValid(String s);

    public static void main(String[] args) {
        System.out.println(new Solution1().isValid("}"));
    }

    // 栈
    public static class Solution1 extends ValidParenthesesTime1 {

        @Override
        public boolean isValid(String s) {
            if (s == null || "".equals(s)) {
                return true;
            }
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
                                                  