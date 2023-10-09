package str;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 单词拆分 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    private Map<String, Boolean> map = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (String word: wordDict) {
            map.put(word, true);
        }

        dp[0] = true;

        // i位置是否可以拆分 -> j可以拆，那么看下j-i区间内是否可以拆
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && map.getOrDefault(s.substring(j, i), false);
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
