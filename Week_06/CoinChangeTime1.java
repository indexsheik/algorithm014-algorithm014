package com.index.apache.thinking.in.algorithm.day37;

import java.util.Arrays;

/**
 * 322. 零钱兑换 中等
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/15 13:25
 * @since
 **/
public abstract class CoinChangeTime1 {

    public abstract int coinChange(int[] coins, int amount);

    public static void main(String[] args) {
        System.out.println(new Solution1().coinChange(new int[]{186, 419, 83, 408}, 20));
    }

    // dp 自上向下
    public static class Solution1 extends CoinChangeTime1 {

        @Override
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount + 1]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem] != 0) return count[rem];
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = res + 1;
                }
            }
            count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem];
        }
    }

    // dp 自下向上
    public static class Solution2 extends CoinChangeTime1 {

        @Override
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            int max = amount + 1;
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
                                                  