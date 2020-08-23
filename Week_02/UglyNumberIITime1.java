package com.index.apache.thinking.in.algorithm.day14;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 * <p>
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/23 22:14
 * @Version： 1.0
 */
public abstract class UglyNumberIITime1 {

    public abstract int nthUglyNumber(int n);

    public static void main(String[] args) {
        UglyNumberIITime1 solution = new Solution1();
        System.out.println(solution.nthUglyNumber(1407));
    }

    public static class Solution1 extends UglyNumberIITime1 {

        @Override
        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> queue = new PriorityQueue<>();
            set.add(1L);
            queue.add(1L);
            long a, c;
            int[] num = new int[]{2, 3, 5};
            int[] result = new int[1690];
            for (int i = 0; i < n; i++) {
                c = queue.poll();
                result[i] = (int) c;
                for (int j : num) {
                    a = c * j;
                    if (!set.contains(a)) {
                        set.add(a);
                        queue.add(a);
                    }
                }

            }
            return result[n - 1];
        }
    }
}
