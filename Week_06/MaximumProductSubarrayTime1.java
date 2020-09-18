package com.index.apache.thinking.in.algorithm.day39;

/**
 * 152. 乘积最大子数组 中等
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/17 16:26
 * @since
 **/
public abstract class MaximumProductSubarrayTime1 {

    public abstract int maxProduct(int[] nums);

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProduct(new int[]{2, 3, -2, 4}));
    }

    public static class Solution1 extends MaximumProductSubarrayTime1 {

        @Override
        public int maxProduct(int[] nums) {
            int l = nums.length;
            int[] maxF = new int[l];
            int[] minF = new int[l];
            System.arraycopy(nums, 0, maxF, 0, l);
            System.arraycopy(nums, 0, minF, 0, l);
            for (int i = 1; i < l; i++) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(maxF[i - 1] * nums[i], nums[i]));
            }
            int res = maxF[0];
            for (int i = 1; i < l; i++) {
                res = Math.max(res, maxF[i]);
            }
            return res;
        }
    }
}
                                                  