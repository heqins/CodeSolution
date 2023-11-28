package str;

import java.util.Scanner;

public class 添加字符后是否为回文串 {

    /**
     * 描述
     * 给定一个字符串，问是否能够通过添加一个字母将其变成“回文串”。 “回文串”是指正着和反着读都一样的字符串。如：”aa”,”bob”,”testset”是回文串，”alice”,”time”都不是回文串。
     *
     * 输入描述
     * 一行一个有小写字母构成的字符串，字符串长度不超过10。
     *
     * 输出描述
     * 如果输入字符串可以通过添加一个字符，则输出”YES”，否则输出”NO”。
     *
     * 示例
     * 输   入：
     * coco
     * 返回值：
     * Yes
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();

            String result = isValid(str);
            System.out.println(result);
        }
    }

    public static String isValid(String str) {
        // coco -> ococo
        if (str.length() < 2) {
            return "Yes";
        }

        int left = 0, right = str.length() - 1;
        char[] chs = str.toCharArray();

        while (left < right && chs[left] == chs[right]) {
            left++;
            right--;
        }

        str = str.substring(left, right + 1);

        if (isParalinrome(str, 1, str.length() - 1) || isParalinrome(str, 0, str.length() - 2) || isParalinrome(str, 0, str.length() - 1)) {
            return "Yes";
        }

        return "No";
    }

    public static boolean isParalinrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
