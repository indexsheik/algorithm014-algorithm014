package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/12 11:21
 * @Version： 1.0
 */
public abstract class ThreeSumTime1 {

    public abstract List<List<Integer>> threeSum(int[] nums);

    public static void main(String[] args) {
        ThreeSumTime1 solution = new ThreeSumTime1.Solution1();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // 三重暴力解法
    // 时间复杂度: O(n^3)
    // 空间复杂度: O(n)
    public static class Solution1 extends ThreeSumTime1 {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                            l.sort(Comparator.naturalOrder());
                            set.add(l);
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }

    // 两重暴力 + hash: a + b + c = 0 -> a + b = -c, 也就是转化成一个 target 会变的 两数之和
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public static class Solution2 extends ThreeSumTime1 {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int target = -nums[i];
                Map<Integer, Integer> map = new HashMap<>(nums.length - 2, 1);
                for (int j = i + 1; j < nums.length; j++) {
                    if (map.containsKey(target - nums[j])) {
                        List<Integer> l = Arrays.asList(nums[i], nums[j], target - nums[j]);
                        l.sort(Comparator.naturalOrder());
                        set.add(l);
                    } else {
                        map.put(nums[j], nums[j]);
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }

    // 夹逼解法
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    // -1, 0, 1, 2, -1, -4
    // 排序
    // -4, -1, -1, 0, 1, 2
    //  ↑   ↑            ↑
    //  i  left         right
    // i 的值大于0, 则跳出, 因为 0 < nums[i] <= nums[left] <= nums[right], 所以大于 0 后不可能相加 = 0
    // 如果 i 的值等于 i - 1 的值, 则跳过, 因为就算再迭代一次也是重复的情况
    // left + right 的值小于 i 的值时, left 右移
    // left + right 的值大于 i 的值时, right 左移
    // 相等则记录
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public static class Solution3 extends ThreeSumTime1 {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) ;
                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return result;
        }
    }
}
