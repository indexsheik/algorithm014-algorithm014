package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/13 23:56
 * @Version： 1.0
 */
public abstract class RotateArrayTime1 {

    public abstract void rotate(int[] nums, int k);

    public static void main(String[] args) {
        RotateArrayTime1 solution = new Solution3();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    // 暴力法
    // 时间复杂度: O(k*n)
    // 空间复杂的: O(1)
    public static class Solution1 extends RotateArrayTime1 {

        @Override
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            for (int i = 0; i < k; i++) {
                for (int j = nums.length - 1; j > 0; j--) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // 翻转三次数组
    // 时间复杂度: O(n)
    // 空间复杂的: O(1)
    public static class Solution2 extends RotateArrayTime1 {

        @Override
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }

    // 环状替换(抢椅子)
    // 时间复杂度: O(n)
    // 空间复杂的: O(1)
    public static class Solution3 extends RotateArrayTime1 {

        @Override
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            for (int start = 0, count = 0; count < nums.length; start++) {
                int curr = start;
                int prev = nums[start];
                do {
                    int next = (curr + k) % nums.length;
                    int tmp = nums[next];
                    nums[next] = prev;
                    curr = next;
                    prev = tmp;
                    count++;
                } while (start != curr);
            }
        }
    }
}
