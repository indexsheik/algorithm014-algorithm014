package com.index.apache.thinking.in.algorithm.day26;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人 简单
 * <p>
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/9/3 22:16
 * @Version： 1.0
 */
public abstract class WalkingRobotSimulationTime1 {

    public abstract int robotSim(int[] commands, int[][] obstacles);

    public static void main(String[] args) {
        System.out.println(new Solution1().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }

    public static class Solution1 extends WalkingRobotSimulationTime1 {

        @Override
        public int robotSim(int[] commands, int[][] obstacles) {
            int x = 0, y = 0, res = 0, dir = 0;
            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {1, 0, -1, 0};
            Set<String> set = new HashSet<>();
            for (int[] obstacle : obstacles) {
                set.add(obstacle[0] + "," + obstacle[1]);
            }
            for (int i : commands) {
                if (i == -1) {
                    dir = (dir + 1) % 4;
                } else if (i == -2) {
                    dir = (dir + 3) % 4;
                } else {
                    for (int j = 0; j < i; j++) {
                        int tx = x + dirX[dir];
                        int ty = y + dirY[dir];
                        String target = tx + "," + ty;
                        if (!set.contains(target)) {
                            x = tx;
                            y = ty;
                            res = Math.max(res, x * x + y * y);
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
