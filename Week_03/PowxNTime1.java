package com.index.apache.thinking.in.algorithm.day20;

/**
 * 50. Pow(x, n) 中等
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/30 00:48
 * @Version： 1.0
 */
public abstract class PowxNTime1 {

    public abstract double myPow(double x, int n);

    public static void main(String[] args) {
        System.out.println(new Solution1().myPow(2.0, Integer.MIN_VALUE));
    }

    public static class Solution1 extends PowxNTime1 {

        @Override
        public double myPow(double x, int n) {
            long a = n;
            return compute(x, a);
        }

        public double compute(double x, long n) {
            if (n < 0) return compute(1 / x, -n);
            double res = 1.0;
            for (long i = n; i != 0; i /= 2) {
                if (i % 2 != 0) {
                    res *= x;
                }
                x *= x;
            }
            return res;
        }
    }
}
