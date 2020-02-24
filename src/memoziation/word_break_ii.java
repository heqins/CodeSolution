/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
**/

public class test {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> d = new HashSet<String>();
        d.addAll(wordDict);
        Map<String, List<String>> memo = new HashMap<String, List<String>>();
        return computeList(s, d, memo);
    }

    public List<String> computeList(String s, Set<String> d, Map<String, List<String>> memo){
        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<String> currList = new ArrayList<String>();
            for (int j = 0; j < s.length(); j++) {
                String sub = s.substring(0, j + 1);
                if (d.contains(sub)) {
                    String rem = s.substring(j + 1);
                    if(rem.equals("")) {
                        currList.add(sub);
                    }
                    else {
                        List<String> r = computeList(rem, d, memo);
                        for (String str : r) {
                            currList.add(sub+" "+str);
                        }
                    }
                }
            }
            memo.put(s, currList);
            return currList;
        }
    }
