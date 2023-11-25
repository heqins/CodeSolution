package num;

import java.util.HashMap;
import java.util.Map;

public class 分数到小数_3 {

    /**
     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
     *
     * 如果小数部分为循环小数，则将循环的部分括在括号内。
     *
     * 如果存在多个答案，只需返回 任意一个 。
     *
     * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
     */

    public static void main(String[] args) {
        fractionToDecimal(5, 6);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        int flag = 1;

        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            flag = -1;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        long q = a / b;
        long r = a % b;

        if (r == 0) {
            return String.valueOf(q * flag);
        }

        StringBuilder sb = new StringBuilder(String.valueOf(q));
        sb.append(".");

        int len = sb.length();
        Map<Long, Integer> map = new HashMap();

        for (int i = 0; i < 10000; i++) {
            a = r * 10;
            q = a / b;
            r = a % b;

            if (map.containsKey(a)) {
                sb.insert((int)map.get(a), '(');
                sb.append(')');
                break;
            }

            sb.append(String.valueOf(q));
            map.put(a, i + len);
            if (r == 0) {
                break;
            }
        }

        if (flag == -1) {
            return "-" + sb.toString();
        }

        return sb.toString();
    }
}
