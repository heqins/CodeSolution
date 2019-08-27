package Str;

import java.util.Arrays;

public class reverse_string {
    public void reverseString(char[] s) {
        int i = 0;
        while (i < s.length / 2) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
            i += 1;
        }
    }

    public static void main(String[] args) {
        reverse_string rs = new reverse_string();
        char[] test = new char[]{'h','e','l','l','o', 'w', 'o', 'l'};
        System.out.println(Arrays.toString(test));
        rs.reverseString(test);
        System.out.println(Arrays.toString(test));
    }
}
