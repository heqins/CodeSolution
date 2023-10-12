package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 复原ip地址 {

    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
     * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();

        // 0111 256111 1010101010
        helper(s, result, new ArrayList(), 0);

        return result;
    }

    public void helper(String s, List<String> result, List<String> temp, int index) {
        if (index == s.length()) {
            if (temp.size() == 4) {
                // 不需要想在哪里插入.，考虑数字加到list后连接就好
                result.add(String.join(".", temp));
            }

            return;
        }

        // 在每个位置有3种切割方式
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                continue;
            }

            String sub = s.substring(index, index + i);

            Integer val = Integer.parseInt(sub);

            if (val > 255 || (sub.length() > 1 && sub.startsWith("0"))) {
                continue;
            }

            temp.add(sub);

            helper(s, result, temp, index + i);

            temp.remove(temp.size() - 1);
        }
    }
}
