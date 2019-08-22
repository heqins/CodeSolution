package Str;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于这种列出所有结果的题首先还是考虑用递归Recursion来解，由于字符串只有左括号和右括号两种字符，
 * 而且最终结果必定是左括号3个，右括号3个，
 * 所以我们定义两个变量left和right分别表示剩余左右括号的个数，
 * 如果在某次递归时，左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数
 */

public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(n, n, res, "");
        return res;
    }

    void helper(int left, int right, ArrayList<String> res, String out) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
        }

        helper(left-1, right, res, out + "(");
        helper(left, right-1, res, out + ")");
    }

    public static void main(String[] args) {
        generate_parentheses gp = new generate_parentheses();
        System.out.println(gp.generateParenthesis(2));
    }
}
