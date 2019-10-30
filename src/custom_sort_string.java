import java.util.*;

public class custom_sort_string {
    public String customSortString(String S, String T) {
        if(T == null || T.length() == 0)
            return T;
        if(S == null || S.length() == 0)
            return T;
        int[] arr = new int[26];
        List<Character> tLeft = new ArrayList<>();
        Set<Character> sSet = new HashSet<>();

        for (char c: S.toCharArray()) {
            sSet.add(c);
        }

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            arr[c-'a']++;

            if (!sSet.contains(c)) {
                tLeft.add(c);
            }
        }

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = arr[c-'a'];
            for (int i1 = 0; i1 < count; i1++) {
                s.append(c);
            }
        }

        for (Character character : tLeft) {
            s.append(character);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        custom_sort_string css = new custom_sort_string();
        System.out.println(css.customSortString("cba", "abcd"));
    }
}
