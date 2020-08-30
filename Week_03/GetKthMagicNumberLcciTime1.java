package com.index.apache.thinking.in.algorithm.day21;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数 中等
 * <p>
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/30 21:47
 * @Version： 1.0
 */
public abstract class GetKthMagicNumberLcciTime1 {

    public abstract int getKthMagicNumber(int k);

    public static void main(String[] args) {
        System.out.println(new Solution1().getKthMagicNumber(10));
    }

    public static class Solution1 extends GetKthMagicNumberLcciTime1 {

        @Override
        public int getKthMagicNumber(int k) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            queue.add(1L);
            set.add(1L);
            int[] ints = new int[]{3, 5, 7};
            int[] res = new int[1000];
            long cur;
            long newNum;
            for (int i = 0; i < k; i++) {
                cur = queue.poll();
                res[i] = (int) cur;
                for (int j : ints) {
                    newNum = cur * j;
                    if (!set.contains(newNum)) {
                        queue.add(newNum);
                        set.add(newNum);
                    }
                }
            }
            return res[k - 1];
        }
    }
}
