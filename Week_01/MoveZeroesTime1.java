package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/11 10:07
 * @since
 **/
public abstract class MoveZeroesTime1 {

    // 思路
    // 1. 新建数组(不符合题目要求)
    // 2. 双指针
    // 将非零的数放到游标处, 游标++, 余下位都为0
    // 3. 交换, 将非零的数与游标处交换
    // 4. 双指针设置 0
    // 将非零的数放到游标处, 如果不是当前游标, 则设置0

    public abstract void moveZeroes(int[] nums);

    public static void main(String[] args) {
        MoveZeroesTime1 solution = new MoveZeroesTime1.Solution4();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    // 新建数组(不符合题目要求)
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends MoveZeroesTime1 {

        @Override
        public void moveZeroes(int[] nums) {
            int cursor = 0;
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    a[cursor++] = nums[i];
                }
            }
        }
    }

    // 指针, 两次遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution2 extends MoveZeroesTime1 {

        @Override
        public void moveZeroes(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[cursor++] = nums[i];
                }
            }
            for (int i = cursor; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    // 交换
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution3 extends MoveZeroesTime1 {

        @Override
        public void moveZeroes(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[cursor];
                    nums[cursor++] = tmp;
                }
            }
        }
    }

    // 指针, 设置 0
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution4 extends MoveZeroesTime1 {

        @Override
        public void moveZeroes(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[cursor] = nums[i];
                    if (i != cursor) {
                        nums[i] = 0;
                    }
                    cursor++;
                }
            }
        }
    }
}
                                                  