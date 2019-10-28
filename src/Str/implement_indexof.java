package Str;

public class implement_indexof {
    public static int[] getFailure(String s) {
        int length = s.length();
        int[] failure = new int[length];
        int i = 0, j = -1;
        failure[0] = -1;
        while (i < length - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                failure[i] = j;
            }
            else {
                j = failure[j];
            }
        }
        return failure;
    }

    public int kmp(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] next = getFailure(t);
        int i = 0, j = 0;
        while (i < sLength && j < tLength) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if (j == tLength) {
            return i - j;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() == 0)
            return -1;
        return kmp(haystack, needle);
    }

    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int nLength = needle.length();
        for (int i = 0; i < haystack.length() - nLength + 1; i ++) {
            String possNeedle = haystack.substring(i, i + nLength);
            if (possNeedle.equals(needle)) return i;
        }
        return -1;
    }
}
