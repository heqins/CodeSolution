package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文子字符串 {

    /**
     * 题目：输入一个字符串，要求将它分割成若干子字符串，使每
     * 个子字符串都是回文。请列出所有可能的分割方法。例如，输
     * 入"google"，将输出3种符合条件的分割方法，分别是
     * ["g"，"o"，"o"，"g"，"l"，"e"]、["g"，"oo"，"g"，"l"，"e"]
     * 和["goog"，"l"，"e"]。
     */
    public static List<List<String>> partition(String word) {
        List<List<String>> result = new ArrayList<>();

        helper(result, new LinkedList<>(), word, 0);

        return result;
    }

    public static void helper(List<List<String>> result, LinkedList<String> subset, String word, int index) {
        if (index == word.length()) {
            result.add(new LinkedList<>(subset));
            return;
        }

        for (int i = index; i < word.length(); i++) {
            // 回溯加双指针，右边界遍历
            if (isPalindrome(word, index, i)) {
                subset.add(word.substring(index, i + 1));
                helper(result, subset, word, i + 1);

                subset.removeLast();
            }
        }
    }

    public static boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
