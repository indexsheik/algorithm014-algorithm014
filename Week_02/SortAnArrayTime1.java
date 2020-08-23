package com.index.apache.thinking.in.algorithm.day11;

/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/21 00:07
 * @Version： 1.0
 */
public abstract class SortAnArrayTime1 {

    public abstract int[] sortArray(int[] nums);

    public static void main(String[] args) {
        SortAnArrayTime1 solution = new Solution1();
        int[] ints = solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    // 快速排序
    // 时间复杂度: O(nlogn)
    // 空间复杂度: O(logn) ~ O(n)
    public static class Solution1 extends SortAnArrayTime1 {

        @Override
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int l, int r) {
            if (l < r) {
                int i = l, j = r;
                int x = nums[i];
                while (i < j) {
                    while (i < j && nums[j] > x) {
                        j--;
                    }
                    if (i < j) {
                        nums[i++] = nums[j];
                    }

                    while (i < j && nums[i] < x) {
                        i++;
                    }

                    if (i < j) {
                        nums[j--] = nums[i];
                    }
                }
                nums[i] = x;

                quickSort(nums, l, i - 1);
                quickSort(nums, i + 1, r);
            }
        }
    }

    // 归并排序 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution2 extends SortAnArrayTime1 {

        @Override
        public int[] sortArray(int[] nums) {

            return nums;
        }

    }

    // 堆排序 TODO
    // 时间复杂度:
    // 空间复杂度:
    public static class Solution3 extends SortAnArrayTime1 {

        @Override
        public int[] sortArray(int[] nums) {

            return nums;
        }

    }
}
