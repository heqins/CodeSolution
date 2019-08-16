/**
 * 看到括号匹配，大家一般都想到用一个栈，其实不用栈也可以。
 *
 * 我们只需要一个变量count保存左括号数-右括号数即可。
 * 即遇到左括号则自增1，遇到右括号则自减1.当count为0的时候，说明在这一段中左括号和右括号相等，是个完美匹配的括号串了。
 *
 * 我们使用一个变量previ保存的是上一次括号完全匹配之后，下一个括号匹配开始位置。
 * 由于这个题需要让我们把最外层的括号去掉，所以，当count==0的时候，我们把结果增加的是[previ + 1, i)，左闭右开区间。
 */

public class removeoutmostp {
    public String removeOuterParentheses(String S) {
        int count = 0;
        int previ = 0;
        String res = "";
        int i = 0;
        for (char c: S.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count --;
            if (count == 0) {
                res += S.substring(previ+1, i);
                previ = i + 1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "(()())(())(()(()))";
        removeoutmostp r = new removeoutmostp();
        System.out.println(r.removeOuterParentheses(test));
    }
}
