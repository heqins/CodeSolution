import java.util.HashMap;

public class longest_substring_without_repeating {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> count = new HashMap();
        int j = 0;
        int max = 0;
        for (int i =0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                j = Math.max(j, count.get(s.charAt(i)) + 1);
            }
            count.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating ls = new longest_substring_without_repeating();
        System.out.println(ls.lengthOfLongestSubstring("abdscddaaa"));
    }
}
