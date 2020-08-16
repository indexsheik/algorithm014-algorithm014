package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Arrays;

/**
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/11 12:13
 * @since
 **/
public abstract class PlusOneTime1 {

    // 思路
    // 最后一项 + 1, 如果不是 10, 则返回结果, 是 10, 则当前为0, 继续循环
    // 如果第1位也需要进位, 则可直接设置1开头的数组

    public abstract int[] plusOne(int[] digits);

    public static void main(String[] args) {
        PlusOneTime1 solution = new PlusOneTime1.Solution1();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }

    // 从最后一项开始加 1
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends PlusOneTime1 {

        @Override
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

    // 别人的写法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends PlusOneTime1 {

        @Override
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                if (digits[i] % 10 == 0) {
                    digits[i] = 0;
                } else {
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
}
                                                  