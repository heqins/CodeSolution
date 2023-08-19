package str;

public class 不含重复字符的最长子字符串 {

    /**
     * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
     * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc"，长度为3。
     * @param args
     */
    public static void main(String[] args) {
        String str = "babcca";
        int i = find(str);

        System.out.println(i);
    }

    public static int find(String word) {
        if (word.length() == 0) {
            return 0;
        }

        int[] value = new int[256];
        int max = 0;
        int j = -1;

        for (int i = 0; i < word.length(); i++) {
            value[word.charAt(i)]++;

            while (hasGreaterThan1(value)) {
                ++j;
                value[word.charAt(j)]--;
            }

            max = Math.max(max, i - j);
        }

        return max;
    }

    public static boolean hasGreaterThan1(int[] nums) {
        for (int num: nums) {
            if (num > 1) {
                return true;
            }
        }

        return false;
    }
}
