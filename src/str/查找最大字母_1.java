package str;

public class 查找最大字母_1 {

    /**
     * 题目描述
     * 对于输入的每个字符串，查找其中的最大字母，在该字母后面插入字符串“(max)”。
     *
     * 输入格式
     * 输入数据包括多个测试实例，每个实例由一行长度不超过100的字符串组成，字符串仅由小写字母构成
     *
     * 输出格式
     * 对于每个测试实例输出一行字符串，输出的结果是插入字符串“(max)”后的结果，如果存在多个最大的字母，就在每一个最大字母后面都插入"(max)"。
     *
     * 样例输入content_copy
     * abcdefgfedcba
     * xxxxx
     * 样例输出content_copy
     * abcdefg(max)fedcba
     * x(max)x(max)x(max)x(max)x(max)
     */

    public static void main(String[] args) {
        System.out.println(findMax("xxxxx"));
    }

    public static String findMax(String str) {
        char max = ' ';
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] > max) {
                max = chs[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
            if (chs[i] == max) {
                sb.append("(max)");
            }
        }

        return sb.toString();
    }
}
