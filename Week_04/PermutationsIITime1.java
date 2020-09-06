package com.index.apache.thinking.in.algorithm.day22;

import java.util.*;

/**
 * 47. 全排列 II 中等
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/28 23:21
 * @Version： 1.0
 */
public abstract class PermutationsIITime1 {

    public abstract List<List<Integer>> permuteUnique(int[] nums);

    public static void main(String[] args) {
        System.out.println(new Solution1().permuteUnique(new int[]{1, 1, 2}));
    }

    public static class Solution1 extends PermutationsIITime1 {

        List<List<Integer>> result = new ArrayList<>();

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            recursion(nums, 0, new ArrayList<>());
            return result;
        }

        private void recursion(int[] nums, int first, List<Integer> list) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = first; i < nums.length; i++) {
                if(set.contains(nums[i])){
                    continue;
                }
                set.add(nums[i]);
                swap(nums, first, i);
                list.add(nums[first]);
                recursion(nums, first + 1, list);
                list.remove(list.size() - 1);
                swap(nums, first, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }
}
