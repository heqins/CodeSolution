package DataStructure;

import java.util.Arrays;

public class yingyong_03_03 {
    public static int[] getFailure(String target) {
        int j = 0;
        int k = -1;
        int[] f = new int[target.length()];
        f[0] = -1;
        while (j < target.length() - 1) {
            if (k == -1 || target.charAt(k) == target.charAt(j)) {
                f[++j] = ++k;
            }else {
                k = f[k];
            }
        }
        return f;
    }

    public static int[] getFailure2(String target) {
        int j = 0;
        int k = -1;
        int[] f = new int[target.length()];
        f[0] = -1;
        while (j < target.length() - 1) {
            if (k == -1 || target.charAt(k) == target.charAt(j)) {
                f[++j] = ++k;
                if (target.charAt(k) == target.charAt(j)) {
                    f[j] = f[k]; // f[]相同
                }else {
                    f[j] = k; // 不变
                }
            }else {
                k = f[k];
            }
        }
        return f;
    }
    public static void main(String[] args) {
        String S = "ABCABCAAA";
        System.out.println(Arrays.toString(getFailure2(S)));
    }
}
