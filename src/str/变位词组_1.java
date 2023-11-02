package str;

import java.util.*;

public class 变位词组_1 {

    /**
     * 题目：给定一组单词，请将它们按照变位词分组。例如，输入
     * 一组单词["eat"，"tea"，"tan"，"ate"，"nat"，"bat"]，这组单
     * 词可以分成3组，分别是["eat"，"tea"，"ate"]、["tan"，"nat"]
     * 和["bat"]。假设单词中只包含英文小写字母。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);

            map.putIfAbsent(temp, new LinkedList<>());
            map.get(temp).add(str);
        }

        return new LinkedList<>(map.values());
    }
}
