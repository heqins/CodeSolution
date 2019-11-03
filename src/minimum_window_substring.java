import java.util.HashMap;
import java.util.Map;

public class minimum_window_substring {
    // two pointers, hashmap
    public String minWindow(String s, String t) {
        // corner case
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> wordDict = constructDict(t);

        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if (count == null) {
                continue;
            }
            wordDict.put(ch, count - 1);
            if (count == 1) {
                // 1->0
                matchCount++;
            }

            while (matchCount == wordDict.size()) {
                // find a valid substring
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftMost = s.charAt(slow++);
                Integer leftMostCount = wordDict.get(leftMost);
                if (leftMostCount == null) {
                    continue;
                }
                wordDict.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }

    private Map<Character, Integer> constructDict(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            }else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }
}
