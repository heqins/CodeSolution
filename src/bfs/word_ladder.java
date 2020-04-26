import java.util.*;

/**
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*//

public class word_ladder {
    // 单词阶梯
    /**
    The first intuition for this problem is to build a graph whose nodes represent strings and edges connect strings that are only 1 character apart, and then we apply BFS from the startWord node. If we find the endWord, we return the level count of the bfs. This intuition is correct, but there are some places that we can save time.

    When we build adjacency list graph, we don't use two loops to check every pair of string to see if they are 1 character apart. Instead, we make changes to current string to obtain all the strings we can reach from current node, and see if it is in the wordList. Thus, there are currentString.length() * 25 case we need to check for every node. This is faster when the wordList set is large, since the check-every-pair method need wordList.size() * currentString.length() for each node. Otherwise, your may exceed the running time limit.

    For the strings we visited, we remove it from the wordList. This way we don't need to mark visited using another HashSet or something.

    Actually, we don't even need to build the adjacency list graph explicitly using a HashMap<String, ArrayList>, since we keep all the nodes we can reach in the queue of each level of BFS. This can be seen as the keys of the HashMap are the strings that in the queue, and values are the strings that satisfy the 1 character apart in the wordList. Thus, we avoid the time cost of build map for those nodes we don't need to visit.
    **/
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<String>();
        int length = 0;
        set.add(endWord);
        q.add(beginWord);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) return length + 1;
                wordMatch(w, set, q);
            }
            length++;
        }
        return 0;
    }
    
    public void wordMatch(String w, Set<String> set, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (word[i] == c) continue;
                word[i] = c;
                String s = String.valueOf(word);
                if (set.contains(s)) {
                    set.remove(s);
                    q.offer(s);
                }
            }
        }
    }
  
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}

// 双端dfs
// TLE caused by searching whether target already exists in the wordList if (!visited.contains(target) && wordList.contains(target)) {...}as the contains() consumes O(n) time, converting the input to Set<> would solve it

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        
        int len = 1;
        int strLen = beginWord.length();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        if(!wordList.contains(endWord)) return 0;

        Set<String> visited = new HashSet<String>();
        Set<String> dict = new HashSet<>(wordList);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> t = beginSet;
                beginSet = endSet;
                endSet = t;
            }
            
            Set<String> temp = new HashSet<String>();
            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        
                        String target = String.valueOf(chs);
                        
                        if (endSet.contains(target)) return len + 1;

                        if (dict.contains(target) && !visited.contains(target)) {
                            visited.add(target);
                            temp.add(target);
                        }
                        
                        chs[i] = old;
                    }
                }
            }
            
            beginSet = temp;
            len++;
        }
        
        return 0;
    }
}
