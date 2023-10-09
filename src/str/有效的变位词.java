package str;

public class 有效的变位词 {

    /**
     * 题目：给定两个字符串s和t，请判断它们是不是一组变位词。
     * 在一组变位词中，它们中的字符及每个字符出现的次数都相同，但
     * 字符的顺序不能相同。例如，"anagram"和"nagaram"就是一组变位
     * 词。
     * @param args
     */
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return false;
        }

        if (s.length() != t.length()) {
            return false; // 长度不相等，不可能是一组变位词
        }

        int[] charCount = new int[26]; // 使用一个长度为26的数组来统计字符出现的次数

        // 遍历字符串s，增加字符计数
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // 遍历字符串t，减少字符计数
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        // 如果所有字符的计数都为0，则是一组变位词
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
