package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/10 23:35
 * @Version： 1.0
 */
public abstract class ClimbingStairsTime1 {

    // 思路
    // 1. 递归, 但是因为有重复计算, 时间复杂度较高
    // 2. 记忆化搜索, 将计算过的数据进行缓存, 提升递归性能
    // 3. 动态规划
    // 通项表达式: f(n) =  f(n-2) + f(n-1)
    // 边界: f(1)=1 f(2)=2
    // 通过表达式和边界进行计算
    // 使用数组记录每个计算的值
    // 4. 动态规划
    // 使用数组记录计算值还可以优化成, 只用2个值记录即可

    public abstract int climbStairs(int n);

    public static void main(String[] args) {
        ClimbingStairsTime1 solution = new Solution1();
        System.out.println(solution.climbStairs(6));
    }

    // 动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution1 extends ClimbingStairsTime1 {

        @Override
        public int climbStairs(int n) {
            if (n < 3) {
                return n == 1 ? 1 : 2;
            }
            int tmp = 0, x = 1, y = 2;
            for (int i = 3; i <= n; i++) {
                tmp = x + y;
                x = y;
                y = tmp;
            }
            return tmp;
        }
    }

    // 递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution2 extends ClimbingStairsTime1 {

        Map<Integer, Integer> map = new HashMap<>();

        @Override
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            if (map.containsKey(n)) {
                return map.get(n);
            }

            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }

    // 矩阵快速幂 TODO
    // 时间复杂度: O(log n)
    // 空间复杂度: O(1)
    public static class Solution3 extends ClimbingStairsTime1 {

        @Override
        public int climbStairs(int n) {
            return 0;
        }
    }

}
