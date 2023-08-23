package str;

public class 外星语言是否排序 {

    /**
     * 题目：有一门外星语言，它的字母表刚好包含所有的英文小写
     * 字母，只是字母表的顺序不同。给定一组单词和字母表顺序，请判
     * 断这些单词是否按照字母表的顺序排序。例如，输入一组单词
     * ["offer"，"is"，"coming"]，以及字母表顺
     * 序"zyxwvutsrqponmlkjihgfedcba"，由于字母'o'在字母表中位
     * 于'i'的前面，因此单词"offer"排在"is"的前面；同样，由于字
     * 母'i'在字母表中位于'c'的前面，因此单词"is"排在"coming"的前
     * 面。因此，这一组单词是按照字母表顺序排序的，应该输出true。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *
     * @param array
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] array, String order) {
        int[] orderArray = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (!isSorted(array[i], array[i + 1], orderArray)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(String word1, String word2, int[] order) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            if (order[word1.charAt(i) - 'a'] < order[word2.charAt(i) - 'a']) {
                return true;
            }

            if (order[word1.charAt(i) - 'a'] > order[word2.charAt(i) - 'a']) {
                return false;
            }
        }

        return i == word1.length();
    }
}
