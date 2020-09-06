package com.index.apache.thinking.in.algorithm.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合 中等
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/31 11:00
 * @since
 **/
public abstract class LetterCombinationsOfAPhoneNumberTime1 {

    public abstract List<String> letterCombinations(String digits);

    public static void main(String[] args) {
        System.out.println(new Solution1().letterCombinations("23"));
    }

    public static class Solution1 extends LetterCombinationsOfAPhoneNumberTime1 {

        Map<String, String[]> map = new HashMap<>();

        List<String> res = new ArrayList<>();

        String[] nums;

        @Override
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return res;
            initMap();
            this.nums = digits.split("");
            recursion(0, "");
            return res;
        }

        private void recursion(int numIndex, String s) {
            if (s.length() == nums.length) {
                res.add(s);
                return;
            }

            String[] word = map.get(nums[numIndex]);
            for (int i = 0; i < word.length; i++) {
                recursion(numIndex + 1, s + word[i]);
            }
        }

        private void initMap() {
            map.put("2", new String[]{"a", "b", "c"});
            map.put("3", new String[]{"d", "e", "f"});
            map.put("4", new String[]{"g", "h", "i"});
            map.put("5", new String[]{"j", "k", "l"});
            map.put("6", new String[]{"m", "n", "o"});
            map.put("7", new String[]{"p", "q", "r", "s"});
            map.put("8", new String[]{"t", "u", "v"});
            map.put("9", new String[]{"w", "x", "y", "z"});
        }
    }
}
                                                  