package str;

public class 字符串相加 {

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     *
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();

        int carry = 0;

        int i = len1 - 1, j = len2 - 1;
        // 不需要用&&，因为下面有判断条件i>=0, j>=0
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;

            int b = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = a + b + carry;

            carry = sum / 10;

            sum = sum % 10;

            sb.append(sum);

            i--;
            j--;
        }

        // 所有位置遍历完以后，还要看看最后的carry位是否有值，如果有值还要加到字符串里
        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
