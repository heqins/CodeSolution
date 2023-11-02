package str;

import java.util.ArrayList;
import java.util.List;

public class 括号生成_1 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        int left = n, right = n;

        helper(left, right, "", result);

        return result;
    }

    public void helper(int left, int right, String temp, List<String> result) {
        // 不能先用完右括号，必须起码左括号数量>右括号的
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(temp);
        }

        helper(left - 1, right, temp + "(", result);
        helper(left, right - 1, temp + ")" , result);
    }
}
