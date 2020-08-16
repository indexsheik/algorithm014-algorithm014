package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/10 22:12
 * @Version： 1.0
 */
public abstract class ValidPalindromeTime1 {

    // 思路
    // 1. 去掉多余字符后, 翻转字符串, 相等则是回文
    // 2. 双指针同时向中间移动, 如果是多余字符则跳过比较

    public abstract boolean isPalindrome(String s);

    public static void main(String[] args) {
        ValidPalindromeTime1 solution = new ValidPalindromeTime1.Solution1();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    // 双指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution1 extends ValidPalindromeTime1 {

        @Override
        public boolean isPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return true;
            }
            int left = 0, right = s.length() - 1;
            do {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                    continue;
                }
                if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            } while (left < right);

            return true;
        }
    }
}
