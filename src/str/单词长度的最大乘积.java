package str;

import java.util.Arrays;

public class 单词长度的最大乘积 {

    /**
     * 输入一个字符串数组words，请计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值。
     * 如果所有字符串都包含至少一个相同字符，那么返回0。假设字符串中只包含英文小写字母。
     * 例如，输入的字符串数组words为["abcw"，"foo"，"bar"，"fxyz"，"abcdef"]，
     * 数组中的字符串"bar"与"foo"没有相同的字符，它们长度的乘积为9。"abcw"与"fxyz"也没有相同的字符，
     * 它们长度的乘积为16，这是该数组不包含相同字符的一对字符串的长度乘积的最大值。
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"};
        int i = solve2(words);
        System.out.println(i);
    }

    /**
     * 时间复杂度：O(n^2+nk)
     * 用数组记录当前单词里每个字母的出现情况
     * @param words
     * @return
     */
    public static int solve1(String[] words) {
        int[][] wordArray = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordArray[i][words[i].charAt(j) - 'a'] = 1;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int count = 0;
                for (int k = 0; k < 26; k++) {
                    if (wordArray[i][k] == 1 && wordArray[j][k] == 1) {
                        break;
                    }

                    count++;
                }

                if (count == 26) {
                    int currentLength = words[i].length() * words[j].length();
                    result = Math.max(currentLength, result);
                }
            }
        }

        return result;
    }

    /**
     * 可以用一个整数里的某一个二进制来代表字符串的某一位字母是否存在，使用的是1左移或位运算来将对应位置置为1
     * @param words
     * @return
     */
    public static int solve2(String[] words) {
        int[] wordArray = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordArray[i] = wordArray[i] | (1 << (words[i].charAt(j) - 'a'));
            }
        }

        System.out.println(Arrays.toString(wordArray));

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordArray[i] & wordArray[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(prod, result);
                }
            }
        }
        return result;
    }
}
