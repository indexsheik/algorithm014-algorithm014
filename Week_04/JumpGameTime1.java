package com.index.apache.thinking.in.algorithm.day26;

/**
 * 55. 跳跃游戏 中等
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/9/4 21:57
 * @Version： 1.0
 */
public abstract class JumpGameTime1 {

    public abstract boolean canJump(int[] nums);

    public static void main(String[] args) {
        System.out.println(new Solution1().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static class Solution1 extends JumpGameTime1 {

        @Override
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int length = nums.length;
            int end = length - 1;
            for (int i = length - 2; i >= 0; i--) {
                if (end - i <= nums[i]) {
                    end = i;
                }
            }
            return end == 0;
        }
    }
}
