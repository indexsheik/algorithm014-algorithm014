package com.index.apache.thinking.in.algorithm.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和 中等
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/28 16:07
 * @since
 **/
public abstract class FourSumTime1 {

    public abstract List<List<Integer>> fourSum(int[] nums, int target);

    public static void main(String[] args) {
        System.out.println(new Solution1().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public static class Solution1 extends FourSumTime1 {

        @Override
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) return new ArrayList<>();
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int m = 0; m < nums.length - 3; m++) {
                int min = nums[m] + nums[m + 1] + nums[m + 2] + nums[m + 3];
                if (min > target) break;
                int max = nums[m] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
                if (max < target) continue;
                if (m > 0 && nums[m] == nums[m - 1]) continue;
                for (int n = m + 1; n < nums.length - 2; n++) {
                    int i = n + 1, j = nums.length - 1;
                    min = nums[m] + nums[n] + nums[i] + nums[i + 1];
                    if (min > target) break;
                    max = nums[m] + nums[n] + nums[j] + nums[j - 1];
                    if (max < target) continue;
                    if (n > m + 1 && nums[n] == nums[n - 1]) continue;
                    while (i < j) {
                        int sum = nums[m] + nums[n] + nums[i] + nums[j];
                        if (sum < target) {
                            while (i < j && nums[i] == nums[++i]) ;
                        } else if (sum > target) {
                            while (i < j && nums[j] == nums[--j]) ;
                        } else {
                            result.add(Arrays.asList(nums[m], nums[n], nums[i], nums[j]));
                            while (i < j && nums[i] == nums[++i]) ;
                            while (i < j && nums[j] == nums[--j]) ;
                        }
                    }
                }
            }
            return result;
        }
    }
}
                                                  