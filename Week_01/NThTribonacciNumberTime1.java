package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 1137. 第 N 个泰波那契数
 * <p>
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/10 18:48
 * @since
 **/
public abstract class NThTribonacciNumberTime1 {

    // 思路
    // 1. 递归, 但是因为有重复计算, 时间复杂度较高
    // 2. 记忆化搜索, 将计算过的数据进行缓存, 提升递归性能
    // 3. 动态规划
    // 通项表达式: f(n) = f(n-3) + f(n-2) + f(n-1)
    // 边界: f(0)=0 f(1)=1 f(2)=1
    // 通过表达式和边界进行计算
    // 使用数组记录每个计算的值
    // 4. 动态规划
    // 使用数组记录计算值还可以优化成, 只用3个值记录即可
    // 5. 暴力解法
    // 先计算出有限的值, 再直接获取

    public abstract int tribonacci(int n);

    public static void main(String[] args) {
        NThTribonacciNumberTime1 solution = new Solution4();
        System.out.println(solution.tribonacci(15));
    }

    // 递归
    // 时间复杂度: O(k ^ n), k=3
    // 空间复杂度: O(n)
    public static class Solution1 extends NThTribonacciNumberTime1 {

        @Override
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            if (n > 37) {
                n = 37;
            }
            return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        }
    }

    // 记忆化搜索
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends NThTribonacciNumberTime1 {

        int[] nums = null;

        @Override
        public int tribonacci(int n) {
            if (nums == null) {
                nums = new int[n + 1];
            }

            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }

            if (nums[n] != 0) {
                return nums[n];
            }

            if (n > 37) {
                n = 37;
            }
            return nums[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        }
    }

    // 动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution3 extends NThTribonacciNumberTime1 {

        int[] nums = null;

        @Override
        public int tribonacci(int n) {
            if (nums == null) {
                nums = new int[n + 1];
            }

            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 1;

            if (n <= 2) {
                return nums[n];
            }

            for (int i = 3; i <= n; i++) {
                nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
            }
            return nums[n];
        }
    }

    // 动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution4 extends NThTribonacciNumberTime1 {

        @Override
        public int tribonacci(int n) {
            int first = 0;
            int second = 1;
            int third = 1;

            switch (n) {
                case 0:
                    return first;
                case 1:
                    return second;
                case 2:
                    return third;
            }

            int tmp = 0;
            for (int i = 3; i <= n; i++) {
                tmp = first + second + third;
                first = second;
                second = third;
                third = tmp;
            }
            return tmp;
        }
    }

    // 暴力解法
    // 时间复杂度: O(1)
    // 空间复杂度: O(n)
    public static class Solution5 extends NThTribonacciNumberTime1 {

        int[] nums = new int[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927,
                1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476,
                1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096,
                181997601, 334745777, 615693474, 1132436852, 2082876103};

        @Override
        public int tribonacci(int n) {
            return nums[n];
        }
    }
}
                                                  