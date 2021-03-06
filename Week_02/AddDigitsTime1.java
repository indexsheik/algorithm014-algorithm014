package com.index.apache.thinking.in.algorithm.day12;

/**
 * 258. 各位相加 简单
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/21 23:16
 * @Version： 1.0
 */
public abstract class AddDigitsTime1 {

    public abstract int addDigits(int num);

    public static void main(String[] args) {
        AddDigitsTime1 solution = new Solution1();
        System.out.println(solution.addDigits(38));
    }

    // 递归
    public static class Solution1 extends AddDigitsTime1 {

        @Override
        public int addDigits(int num) {
            if (num < 10) return num;
            int tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            return addDigits(tmp);
        }
    }
}
