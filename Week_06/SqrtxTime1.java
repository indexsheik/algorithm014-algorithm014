package com.index.apache.thinking.in.algorithm.day36;

/**
 * 69. x 的平方根 简单
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/14 16:45
 * @since
 **/
public abstract class SqrtxTime1 {

    public abstract int mySqrt(int x);

    public static void main(String[] args) {
        System.out.println(new Solution1().mySqrt(8));
    }

    // 二分查找
    public static class Solution1 extends SqrtxTime1 {

        @Override
        public int mySqrt(int x) {
            if (x <= 1) return x;
            long l = 1, r = x / 2, m = 0;
            while (l <= r) {
                m = l + (r - l) / 2;
                long s = m * m;
                if (s == x) {
                    return (int) m;
                }
                if (s < x) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return (int) r;
        }
    }

    // 牛顿迭代法
    public static class Solution2 extends SqrtxTime1 {

        @Override
        public int mySqrt(int x) {
            if (x == 0) return 0;
            double c = x, x0 = x;
            while (true) {
                double xi = 0.5 * (x0 + c / x0);
                if (Math.abs(xi - x0) < 1e-7) {
                    break;
                }
                x0 = xi;
            }
            return (int) x0;
        }
    }

}
                                                  