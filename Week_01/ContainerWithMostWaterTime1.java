package com.index.apache.thinking.in.algorithm.homework.week1;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/11 14:48
 * @since
 **/
public abstract class ContainerWithMostWaterTime1 {

    // 思路
    // 1. 暴力解法, 两次循环, 计算每一种情况, 取最大值
    // 2. 双指针, 左右边界向中间收敛, 左右夹逼
    // 取两边边界, 计算值, 高度较小的一边指针向内移动,
    // 原因: 高度较小的一边不变, 另一边向内移动, 只会变小, 也就是说, 高度较小的一边的最大值已经获得了
    // 所以移动高度较小的一边的指针, 重新定义边界, 计算新的边界内的最大值即可

    public abstract int maxArea(int[] height);

    public static void main(String[] args) {
        ContainerWithMostWaterTime1 solution = new ContainerWithMostWaterTime1.Solution4();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    // 暴力解法
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    public static class Solution1 extends ContainerWithMostWaterTime1 {

        @Override
        public int maxArea(int[] height) {
            int result = 0, h = 0, w = 0, tmp = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    h = Math.min(height[i], height[j]);
                    w = j - i;
                    tmp = h * w;
                    if (tmp > result) {
                        result = tmp;
                    }
                }
            }
            return result;
        }
    }

    // 双指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution2 extends ContainerWithMostWaterTime1 {

        @Override
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1, result = 0, tmp = 0;
            do {
                tmp = Math.min(height[left], height[right]) * (right - left);
                if (tmp > result) {
                    result = tmp;
                }
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            } while (left < right);
            return result;
        }
    }

    // 暴力解法(额外练习)
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    public static class Solution3 extends ContainerWithMostWaterTime1 {

        @Override
        public int maxArea(int[] height) {
            int result = 0, tmp = 0;
            // 因为 i 和 j 不会碰撞, 所以 i 的边界可以是 size - 1
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    tmp = Math.min(height[i], height[j]) * (j - i);
                    if (tmp > result) {
                        result = tmp;
                    }
                }
            }
            return result;
        }
    }

    // 双指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static class Solution4 extends ContainerWithMostWaterTime1 {

        @Override
        public int maxArea(int[] height) {
            int result = 0, tmp = 0;
            for (int left = 0, right = height.length - 1; left < right; ) {
                int h = height[left] < height[right] ? height[left++] : height[right--];
                tmp = h * (right - left + 1);
                result = Math.max(result, tmp);
            }
            return result;
        }
    }

}
                                                  