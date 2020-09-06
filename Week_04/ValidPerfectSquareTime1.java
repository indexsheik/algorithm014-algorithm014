package com.index.apache.thinking.in.algorithm.day27;

/**
 * 367. 有效的完全平方数
 * <p>
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/9/5 20:26
 * @Version： 1.0
 */
public abstract class ValidPerfectSquareTime1 {

    public abstract boolean isPerfectSquare(int num);

    public static void main(String[] args) {
        System.out.println(new Solution1().isPerfectSquare(16));
    }

    public static class Solution1 extends ValidPerfectSquareTime1 {

        @Override
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            long left = 2, right = num/2, x, guessSquared;
            while(left<=right){
                x = (left + right)/2;
                guessSquared = x * x;
                if(guessSquared == num) return true;
                else if(guessSquared<num) left = x+1;
                else right=x-1;
            }
            return false;
        }
    }
}
