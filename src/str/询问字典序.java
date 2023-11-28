package str;

import java.util.LinkedList;
import java.util.Scanner;

public class 询问字典序 {

    /**
     * 描述
     * 输入n个字符串S1,S2,...,Sn，对于第i个字符串，你需要回答在前i-1个字符串中，有多少个字符串的字典序严格比Si小。
     *
     * 输入描述
     * 第一行输入一个数n（1≤n≤100000），接下来输入n行，每行一个字符串。所有单个字符串的长度不超过100000，所有字符串的长度之和不超过200000，所有字符串的字符由26个小写字母构成。
     *
     * 输出描述
     * 输出n行n个数，第i个数表示前i-1个串中，有多少个字符串的字典序严格比Si小。
     * 示例
     * 输   入：
     * 5
     * one
     * one
     * two
     * three
     * four
     * 返回值：
     * 0
     * 0
     * 2
     * 2
     * 0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            String key = scanner.next();
            System.out.println(insertSortedList(list, i, key));
        }

        scanner.close();
    }

    static int insertSortedList(String[] list, int size, String key) {
        int left = 0, right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int ret = key.compareTo(list[mid]);

            if (ret > 0) // key > list[mid]
                left = mid + 1;
            else // key <= list[mid]
                right = mid - 1;
        }

        for (int i = size; i > left; i--) {
            list[i] = list[i - 1];
        }

        list[left] = key;
        return left;
    }
}
