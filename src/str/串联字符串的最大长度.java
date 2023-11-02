package str;

import java.util.List;

public class 串联字符串的最大长度 {

    /**
     * 给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
     *
     * 请返回所有可行解 s 中最长长度。
     *
     * 子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = ["un","iq","ue"]
     * 输出：4
     * 解释：所有可能的串联组合是：
     * - ""
     * - "un"
     * - "iq"
     * - "ue"
     * - "uniq" ("un" + "iq")
     * - "ique" ("iq" + "ue")
     * 最大长度为 4。
     * 示例 2：
     *
     * 输入：arr = ["cha","r","act","ers"]
     * 输出：6
     * 解释：可能的解答有 "chaers" 和 "acters"。
     */
    private int result = Integer.MIN_VALUE;

    public int maxLength(List<String> arr) {
        int[] count = new int[26];

        if (arr.size() == 1) {
            for (char ch: arr.get(0).toCharArray()) {
                count[ch - 'a']++;
            }

            if (!check(count)) {
                return 0;
            }

            for (char ch: arr.get(0).toCharArray()) {
                count[ch - 'a']--;
            }

            return arr.get(0).length();
        }


        helper(arr, count, 0, 0);

        return result;
    }

    public void helper(List<String> arr, int[] count, int index, int length) {
        System.out.println("index: " + index + " length: " + length);

        result = Math.max(result, length);

        if (index > arr.size()) {
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            for (char ch: arr.get(i).toCharArray()) {
                count[ch - 'a']++;
            }

            if (!check(count)) {
                for (char ch: arr.get(i).toCharArray()) {
                    count[ch - 'a']--;
                }

                continue;
            }


            helper(arr, count, i + 1, length + arr.get(i).length());

            for (char ch: arr.get(i).toCharArray()) {
                count[ch - 'a']--;
            }
        }
    }

    public boolean check(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                return false;
            }
        }

        return true;
    }
}
