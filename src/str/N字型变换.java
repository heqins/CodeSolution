package str;

import java.util.ArrayList;
import java.util.List;

public class N字型变换 {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     */

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        // 观察发现行坐标会先升后减小，在遍历中把每个字符填到对应的行
        for (int j = 0; j < s.length(); j++) {
            list.get(i).append(s.charAt(j));
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }

            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder temp: list) {
            sb.append(temp.toString());
        }

        return sb.toString();
    }
}
