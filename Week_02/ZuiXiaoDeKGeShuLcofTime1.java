package com.index.apache.thinking.in.algorithm.day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/20 16:18
 * @since
 **/
public abstract class ZuiXiaoDeKGeShuLcofTime1 {

    public abstract int[] getLeastNumbers(int[] arr, int k);

    public static void main(String[] args) {
        ZuiXiaoDeKGeShuLcofTime1 solution = new Solution2();
        int[] result = solution.getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }

    // 排序
    // 时间复杂度: O(nlogn)
    // 空间复杂度: O(logn)
    public static class Solution1 extends ZuiXiaoDeKGeShuLcofTime1 {

        @Override
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOfRange(arr, 0, k);
        }
    }

    // 堆
    // 时间复杂度: O(nlogk)
    // 空间复杂度: O(k)
    public static class Solution2 extends ZuiXiaoDeKGeShuLcofTime1 {

        @Override
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(4,
                    Comparator.reverseOrder());
            for (int i : arr) {
                if (queue.size() < k) {
                    queue.add(i);
                } else if (!queue.isEmpty() && queue.peek() > i) {
                    queue.poll();
                    queue.add(i);
                }
            }
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = queue.poll();
            }
            return arr;
        }
    }

    // 快排的思想 TODO
    public static class Solution3 extends ZuiXiaoDeKGeShuLcofTime1 {

        @Override
        public int[] getLeastNumbers(int[] arr, int k) {
            return new int[0];
        }
    }
}
                                                  