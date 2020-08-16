package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,4,7,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,4,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/14 16:18
 * @since
 **/
public abstract class MergeSortedArrayTime1 {

    public abstract void merge(int[] nums1, int m, int[] nums2, int n);

    public static void main(String[] args) {
        MergeSortedArrayTime1 solution = new Solution2();
        int[] nums1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        solution.merge(nums1, 6, new int[]{1, 2, 2}, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    // 利用副本进行双指针移动放入数组
    // 时间复杂度: O(m+n)
    // 空间复杂度: O(m)
    public static class Solution1 extends MergeSortedArrayTime1 {

        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);
            int p1 = 0, p2 = 0;
            int p = 0;
            while (p1 < m && p2 < n) {
                if (nums1_copy[p1] < nums2[p2]) {
                    nums1[p++] = nums1_copy[p1++];
                } else {
                    nums1[p++] = nums2[p2++];
                }
            }
            if (p1 < m) {
                System.arraycopy(nums1_copy, p1, nums1, p1 + n, m - p1);
            } else {
                System.arraycopy(nums2, p2, nums1, m + p2, n - p2);
            }
        }
    }

    // 从 m 和 n 位置向前移动指针, 将大值放在最后
    // 时间复杂度: O(m+n)
    // 空间复杂度: O(1)
    public static class Solution2 extends MergeSortedArrayTime1 {

        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int p = nums1.length - 1;
            while (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[p--] = nums1[p1--];
                } else {
                    nums1[p--] = nums2[p2--];
                }
            }
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
                                                  