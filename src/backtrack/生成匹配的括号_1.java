package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 生成匹配的括号_1 {

    /**
     * 题目：输入一个正整数n，请输出所有包含n个左括号和n个右括
     * 号的组合，要求每个组合的左括号和右括号匹配。例如，当n等于2
     * 时，有两个符合条件的括号组合，分别是"（()）"和"()()"。
     * @param args
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        helper(n, n, result, "");

        return result;
    }

    public void helper(int left, int right, List<String> result, String str) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(str);

            return;
        }

        helper(left - 1, right, result, str + "(");

        helper(left, right - 1, result, str + ")");
    }
}
