package str;

public class 字符串中的变位词_1 {

    /**
     * 题目：输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？
     * 如果字符串s2中包含字符串s1的某个变位词，则字符串s1至少有一个变位词是字符串s2的子字符串。
     * 假设两个字符串中只包含英文小写字母。例如，字符串s1为"ac"，字符串s2为"dgcaf"，
     * 由于字符串s2中包含字符串s1的变位词"ca"，因此输出为true。如果字符串s1为"ab"，字符串s2为"dgcaf"，则输出为false。
     * @param args
     */
    public static void main(String[] args) {
        boolean b = find("ab", "dgcaf");
        System.out.println(b);
    }

    /**
     * 假设字符串s2中有一个子字符串是字符串s1的变位词，逐个扫描这个变位词中的字母，
     * 并把字母在哈希表中对应的值减1。由于字符串s1的变位词和字符串s1包含相同的字母，
     * 并且每个字母出现的次数也相同，因此扫描完字符串s1的变位词之后，哈希表中所有的值都是0。
     * @param s1
     * @param s2
     * @return
     */
    public static boolean find(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] nums = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }

        if (isAllZero(nums)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            nums[s2.charAt(i) - 'a']--;
            nums[s2.charAt(i - s1.length()) - 'a']++;
            if (isAllZero(nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAllZero(int[] nums) {
        for (int num: nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
