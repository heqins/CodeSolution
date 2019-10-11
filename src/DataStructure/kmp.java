package DataStructure;

public class kmp {
    public static int KMP(String obj, String target) {
        int[] f = getFailure(target);
        int i = 0, j = 0;
        while (i < obj.length() && j < target.length() && target.length() - j <= obj.length() - i) {
            if (j == -1 || target.charAt(j) == obj.charAt(i)) {
                i++;
                j++;
            }else {
                j = f[j];
            }
        }
        if (j < target.length()) {
            return -1;
        }else {
            return i - j; // 匹配成功
        }
    }

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

    public static void main(String[] args) {
        String obj = "ABABCabc";
        String pat = "ABCABCAAA";
        System.out.println(KMP(obj, pat));
    }
}
