package str;

import java.util.Arrays;

public class 最长快乐字符串 {

    /**
     * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
     *
     * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
     *
     * s 是一个尽可能长的快乐字符串。
     * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
     * s 中只含有 'a'、'b' 、'c' 三种字母。
     * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
     */

    // 时间复杂度：(a+b+c)*clogc
    public String longestDiverseString(int a, int b, int c) {
        // 构造数组
        int[][] arr = {{'a', a}, {'b', b}, {'c', c}};

        StringBuilder sb = new StringBuilder(a + b + c);
        while (true) {
            // 按数量从大到小排序
            Arrays.sort(arr, (x, y) -> y[1] - x[1]);
            int n = sb.length();

            // 如果数量最多的为0了，跳出循环
            if (arr[0][1] == 0) {
                break;
            }

            // 如果字符串后两位等于数量最多的字符，那么就使用数量次多的
            if (n >= 2 && sb.charAt(n - 1) == arr[0][0] && sb.charAt(n - 2) == arr[0][0]) {
                // 如果数量次多的为0了，跳出循环
                if (arr[1][1] == 0) {
                    break;
                }
                // 拼接数量次多的，同时其数量减1
                sb.append((char) arr[1][0]);
                arr[1][1]--;
            } else {
                // 不满足上述条件，拼接数量最多的，同时其数量减1
                sb.append((char) arr[0][0]);
                arr[0][1]--;
            }
        }

        return sb.toString();
    }
}
