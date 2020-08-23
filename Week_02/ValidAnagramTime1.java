package com.index.apache.thinking.in.algorithm.day8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoxuezhi
 * @date 2020/8/17 10:21
 * @since
 **/
public abstract class ValidAnagramTime1 {

    public abstract boolean isAnagram(String s, String t);

    public static void main(String[] args) {
        System.out.println(new Solution2().isAnagram("anagram", "nagaram"));
    }

    // 暴力排序
    public static class Solution1 extends ValidAnagramTime1 {

        @Override
        public boolean isAnagram(String s, String t) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            Arrays.sort(sc);
            Arrays.sort(tc);
            return new String(sc).equals(new String(tc));
        }
    }

    // hash
    public static class Solution2 extends ValidAnagramTime1 {

        @Override
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                count.putIfAbsent(s.charAt(i), 0);
                count.putIfAbsent(t.charAt(i), 0);
                count.computeIfPresent(s.charAt(i), (character, integer) -> count.get(character) + 1);
                count.computeIfPresent(t.charAt(i), (character, integer) -> count.get(character) - 1);
            }
            for (Integer i : count.values()) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
                                                  