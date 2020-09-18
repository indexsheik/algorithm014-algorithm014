package com.index.apache.thinking.in.algorithm.day39;

/**
 * 121. 买卖股票的最佳时机 简单
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/17 16:45
 * @since
 **/
public abstract class BestTimeToBuyAndSellStockTime1 {

    public abstract int maxProfit(int[] prices);

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProfit(new int[]{7, 2, 5, 3, 6, 2, 7}));
    }

    public static class Solution1 extends BestTimeToBuyAndSellStockTime1 {

        @Override
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int res = 0, min = prices[0], max = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                    max = prices[i];
                } else if (max < prices[i]) {
                    max = prices[i];
                }
                res = Math.max(max - min, res);
            }
            return res;
        }
    }
}
                                                  