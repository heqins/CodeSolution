package str;

public class 最短回文串 {

    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     */

    public static void main(String[] args) {
        shortestPalindrome("aaaabc");
    }

    // 最短的回文串需要本身找到最长的有效回文串，找到以后再添加一个串来构成新的回文串
    public static String shortestPalindrome(String s) {
        int n = s.length();

        // 理论上最插要n次
        for (int i = n - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                // i + 1 -> n
                String suffix = s.substring(i + 1);
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                return reversedSuffix + s;
            }
        }

        return s; // 如果字符串本身就是回文串，则直接返回
    }

    // 辅助函数：判断字符串 s 中从 start 到 end 的子串是否是回文串
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
