package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串_1 {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();

        helper(result, new ArrayList(), s, 0);

        return result;
    }

    public void helper(List<List<String>> result, List<String> temp, String s, int index) {
        if (index > s.length()) {
            return;
        }

        if (index == s.length()) {
            result.add(new ArrayList(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)) {
                String sub = s.substring(index, i + 1);
                temp.add(sub);
            }else {
                continue;
            }

            helper(result, temp, s, i + 1);

            temp.remove(temp.size() - 1);
        }
    }

    public boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
