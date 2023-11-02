package str;

import java.util.ArrayList;
import java.util.List;

public class 字符串中的所有变位词_1 {

    /**
     * 题目：输入字符串s1和s2，如何找出字符串s2的所有变位词在字符串s1中的起始下标？
     * 假设两个字符串中只包含英文小写字母。例如，字符串s1为"cbadabacg"，字符串s2为"abc"，
     * 字符串s2的两个变位词"cba"和"bac"是字符串s1中的子字符串，输出它们在字符串s1中的起始下标0和5。
     *
     * 示例 1：
     *
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
     *  示例 2：
     *
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integers = find("cbadabacg", "abc");
        System.out.println(integers.toString());
    }

    public static List<Integer> find(String s1, String s2) {
        List<Integer> indices = new ArrayList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }

        int[] nums = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }

        if (isAllZero(nums)) {
            indices.add(0);
        }

        for (int i = s2.length(); i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s1.charAt(i - s2.length()) - 'a']--;
            if (isAllZero(nums)) {
                indices.add(i - s2.length() + 1);
            }
        }

        return indices;
    }

    public static boolean isAllZero(int[] nums) {
        for (int num: nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
