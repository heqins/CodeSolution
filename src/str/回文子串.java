package str;

public class 回文子串 {

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    public int countSubstrings(String word) {
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

    public int isValid(String word, int i, int j) {
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
