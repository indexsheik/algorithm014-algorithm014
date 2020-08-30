package com.index.apache.thinking.in.algorithm.day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列 中等
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 通过次数179,361提交次数233,890
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/28 22:20
 * @Version： 1.0
 */
public abstract class PermutationsTime1 {

    public abstract List<List<Integer>> permute(int[] nums);

    public static void main(String[] args) {
        System.out.println(new Solution1().permute(new int[]{1, 2, 3}));
    }

    public static class Solution1 extends PermutationsTime1 {

        List<List<Integer>> result = new ArrayList<>();

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            recursion(nums.length, list, 0);
            return result;
        }

        private void recursion(int n, List<Integer> nums, int first) {
            if (first == n) {
                result.add(new ArrayList<>(nums));
            }
            for (int i = first; i < n; i++) {
                Collections.swap(nums, first, i);
                recursion(n, nums, first + 1);
                Collections.swap(nums, first, i);
            }
        }
    }
}
