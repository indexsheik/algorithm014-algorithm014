package com.index.apache.thinking.in.algorithm.day8;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/17 13:51
 * @since
 **/
public abstract class IntersectionOfTwoArraysIITime1 {

    public abstract int[] intersect(int[] nums1, int[] nums2);

    public static void main(String[] args) {
        IntersectionOfTwoArraysIITime1 solution = new Solution1();
        int[] result = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // hash
    // 记录小数组每个元素的个数, 大数组遍历保存相同的数, 并对次数减 1
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static class Solution1 extends IntersectionOfTwoArraysIITime1 {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            int[] result = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                } else {
                    map.put(nums1[i], 1);
                }
            }
            int cursor = 0;
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                    result[cursor++] = nums2[i];
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }

            return Arrays.copyOfRange(result, 0, cursor);
        }
    }

    // 排序双指针
    // 时间复杂度: O(n logn)
    // 空间复杂度: O(n)
    public static class Solution2 extends IntersectionOfTwoArraysIITime1 {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            int[] result = new int[Math.min(nums1.length, nums2.length)];
            int cursor = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else if (nums1[i] == nums2[j]) {
                    result[cursor++] = nums1[i];
                    i++;
                    j++;
                }
            }

            return Arrays.copyOfRange(result, 0, cursor);
        }
    }
}
                                                  