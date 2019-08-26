package Str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class first_unique_character {
    public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        int len = s.length();
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            return 0;
        }
        int[] freq = new int[26];
        char[] chars= s.toCharArray();
        for (char c: chars) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int index = -1;
        if (s.length() == 0 || s == null) return index;

        LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) + 1);
            }else {
                hmap.put(c, 1);
            }
        }

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (hmap.get(c) == 1) {
                index = j;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        first_unique_character fuc = new first_unique_character();
        System.out.println(fuc.firstUniqChar(s));
    }
}
