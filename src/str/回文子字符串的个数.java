package str;

public class 回文子字符串的个数 {

    /**
     * 题目：给定一个字符串，请问该字符串中有多少个回文连续子
     * 字符串？例如，字符串"abc"有3个回文子字符串，分别
     * 为"a"、"b"和"c"；而字符串"aaa"有6个回文子字符串，分别
     * 为"a"、"a"、"a"、"aa"、"aa"和"aaa"。
     * @param args
     */
    public static void main(String[] args) {
        int aaa = count("1d");
        System.out.println(aaa);
    }

    public static int count(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count += isValid(word, i, i);
            count += isValid(word, i, i + 1);
        }

        return count;
    }

    public static int isValid(String word, int i, int j) {
        if (i < 0 || j > word.length()) {
            return 0;
        }

        int count = 0;
        while (i >= 0 && j < word.length()) {
            if (word.charAt(i) != word.charAt(j)) {
                break;
            }

            i--;
            j++;

            count += 1;
        }

        return count;
    }
}
