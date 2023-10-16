package array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 小于n的最大数 {
    /**
     * 1.N的前x位数字都在数组A中
     * 2.数组A中存在比N的第x+1位数字更小的数字
     */
    public static String solve(int[] A, int N) {
        Arrays.sort(A);
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int x = -1;
        String str = String.valueOf(N);
        char[] num = str.toCharArray();
        // 下标x应该尽可能大
        for (int i = 0; i < str.length(); i++) {
            // 在数组A中找到num[i]的下标
            int idx = Arrays.binarySearch(A, num[i] - '0');
            idx = idx < 0 ? -(idx + 1) : idx;
            // num[i]在数组A中的下标大于0时才能更新x，因为数组A中至少需要存在1位小于当前数值的数字，这样才能满足条件2
            if (idx > 0) {
                x = i;
            }
            // 不在A数组内直接跳出循环
            if (!set.contains(num[i] - '0')) {
                break;
            }
        }
        // 找到了可行的x位置
        if (x != -1) {
            // 在数组A中找到num[i]的下标(用于获取A[idx - 1])
            int idx = Arrays.binarySearch(A, num[x] - '0');
            idx = idx < 0 ? -(idx + 1) : idx;
            // 剩余字符尽可能大
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - x - 1; i++) {
                sb.append(A[A.length - 1]);
            }
            // 拼接结果字符串
            return str.substring(0, x) + A[idx - 1] + sb;
        }
        // 特殊情况
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - 1; i++) {
                sb.append(A[A.length - 1]);
            }
            return sb.toString();
        }
    }

    private static final Integer one = 1;

    public static void main(String[] args) {

        String t  = solve(new int[]{1, 2, 4, 9, 3}, 111);
        System.out.println(t);

        int i = maxSmallNumberError(new int[]{1, 2, 4, 9, 3}, 111);
        System.out.println(i);
    }

    public static int maxSmallNumberError(int[] A, int n) {
        String numStr = String.valueOf(n);
        int[] maxDigits = new int[10];

        for (int i : A) {
            maxDigits[i] = 1;
        }

        char[] numArray = numStr.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            int digit = numArray[i] - '0';

            for (int j = digit - 1; j >= 0; j--) {
                if (maxDigits[j] == 1) {
                    numArray[i] = (char)('0' + j);

                    for (int k = i + 1; k < numArray.length; k++) {
                        numArray[k] = (char)('0' + A[A.length - 1]);
                    }

                    return Integer.parseInt(new String(numArray));
                }
            }
        }

        return n;
    }

}
