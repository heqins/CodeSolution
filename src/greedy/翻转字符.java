package greedy;

public class 翻转字符 {

    // https://leetcode.cn/problems/flip-string-to-monotone-increasing/description/
    /**
     * 题目：输入一个只包含'0'和'1'的字符串，其中，'0'可以翻转
     * 成'1'，'1'可以翻转成'0'。请问至少需要翻转几个字符，才可以使
     * 翻转之后的字符串中所有的'0'位于'1'的前面？翻转之后的字符串
     * 可能只包含字符'0'或'1'。例如，输入字符串"00110"，至少需要翻
     * 转一个字符才能使所有的'0'位于'1'的前面。可以将最后一个字
     * 符'0'翻转成'1'，得到字符串"00111"。
     * @param args
     */
    public int minFlipsMonoIncr(String s) {
        int result = 0;
        int ones = 0;
        // 贪心算法，在遇到0的时候，如果之前有1，则翻转
        for (char c: s.toCharArray()) {
            if (c == '0') {
                if (ones > 0) {
                    result++;
                    ones--;
                }
            }else {
                ones++;
            }
        }

        return result;
    }
}
