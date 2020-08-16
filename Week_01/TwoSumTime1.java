package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/11 22:43
 * @Version： 1.0
 */
public abstract class TwoSumTime1 {

    public abstract int[] twoSum(int[] nums, int target);

    public static void main(String[] args) {
        TwoSumTime1 solution = new TwoSumTime1.Solution2();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 5, 5, 11}, 10)));
    }

    // 暴力
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    public static class Solution1 extends TwoSumTime1 {

        @Override
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    // 一遍 hash
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution2 extends TwoSumTime1 {

        @Override
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer a;
                if ((a = map.get(target - nums[i])) != null) {
                    return new int[]{a, i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
