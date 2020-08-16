package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/13 22:14
 * @Version： 1.0
 */
public abstract class RemoveDuplicatesFromSortedArrayTime1 {

    public abstract int removeDuplicates(int[] nums);

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayTime1 solution = new RemoveDuplicatesFromSortedArrayTime1.Solution1();
        int[] nums = new int[]{1, 1, 2, 2, 4, 5, 5, 7};
        int length = solution.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            print(nums[i]);
        }
    }

    private static void print(int num) {
        System.out.println(num);
    }

    // 因为是有序的, 一个数字只出现一次, 后面等于 curr 的值都可以变换成一个不在数组中的最小值
    // 这样就转换成了移动零问题, 但是并不需要移到最后, 只需要把不重复的放在前面即可
    // 时间复杂度: O(N) N 的系数为 2
    // 空间复杂度: O(1)
    public static class Solution1 extends RemoveDuplicatesFromSortedArrayTime1 {

        @Override
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int min = nums[0] - 1;
            int curr = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (curr == nums[i]) {
                    nums[i] = min;
                } else if (nums[i] > curr) {
                    curr = nums[i];
                }
            }
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != min) {
                    nums[cursor++] = nums[i];
                }
            }

            return cursor;
        }
    }

    // 快指针 fast 慢指针 slow
    // 如果快指针不等于慢指针, 则 慢指针的下一个位置替换为快指针的值
    // 时间复杂度: O(N)
    // 空间复杂度: O(1)
    public static class Solution2 extends RemoveDuplicatesFromSortedArrayTime1 {

        @Override
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != nums[cursor]) {
                    nums[++cursor] = nums[i];
                }
            }
            return cursor + 1;
        }
    }
}
