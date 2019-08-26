package Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_and_replace_pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words.length == 0 || words == null || pattern == null) {
            return res;
        }
        String patternPat = getPatternStr(pattern);
        for (int i = 0; i < words.length; i++) {
            String wordPat = getPatternStr(words[i]);
            if (wordPat.equals(patternPat)) {
                res.add(words[i]);
            }
        }
        return res;
    }

    public String getPatternStr(String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        StringBuilder sb = new StringBuilder();
        String l = "";

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c) &&  i != 0){
                l = map.get(c);
            }
            else{
                l = i+"";
                map.put(c, l);
            }
            sb.append(l);
        }
        String pat = sb.toString();
        return pat;
    }

    public static void main(String[] args) {
        find_and_replace_pattern farp = new find_and_replace_pattern();
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(farp.findAndReplacePattern(words, pattern));
    }
}
