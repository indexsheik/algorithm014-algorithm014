package com.index.apache.thinking.in.algorithm.day25;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * <p>
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3], [1,1]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: [1,2], [1,2,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/9/3 16:36
 * @since
 **/
public abstract class AssignCookiesTime1 {

    public abstract int findContentChildren(int[] g, int[] s);

    public static void main(String[] args) {
        System.out.println(new Solution1().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2}));
    }

    // 贪心
    public static class Solution1 extends AssignCookiesTime1 {

        @Override
        public int findContentChildren(int[] g, int[] s) {
            int result = 0;
            if (g == null || s == null) return result;
            Arrays.sort(g);
            Arrays.sort(s);
            int m = 0;
            for (int n = 0; n < s.length && m < g.length; n++) {
                if (g[m] <= s[n]) {
                    result++;
                    m++;
                }
            }
            return result;
        }
    }
}
                                                  