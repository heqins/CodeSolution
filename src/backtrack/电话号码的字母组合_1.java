package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合_1 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }

        Map<String, String> map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxzy");

        List<String> res = new ArrayList();
        helper(map, res, digits, "");

        return res;
    }

    public void helper(Map<String, String> map, List<String> res, String digits, String str) {
        if (digits.length() == 0) {
            res.add(str);
            return;
        }

        String digit = digits.substring(0, 1);

        String words = map.get(digit);

        // 不是subString，对于str的length方法是length()
        for (int i = 0; i < words.length(); i++) {
            String temp = words.substring(i, i + 1);

            helper(map, res, digits.substring(1), str + temp);
        }
    }
}
