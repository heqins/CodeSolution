package graph;

import java.util.*;

public class 火星字典 {

    /**
     * 题目：一种外星语言的字母都是英文字母，但字母的顺序未
     * 知。给定该语言排序的单词列表，请推测可能的字母顺序。如果有
     * 多个可能的顺序，则返回任意一个。如果没有满足条件的字母顺
     * 序，则返回空字符串。例如，如果输入排序的单词列表为
     * ["ac"，"ab"，"bc"，"zc"，"zb"]，那么一个可能的字母顺序
     * 是"acbz"。
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"abc", "ab"};
        String w = solve(words);
        System.out.println(w);
    }

    public static String solve(String[] words) {
        // 先构建图
        // 构建图后进行拓扑排序
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        for (String word: words) {
            for (char ch: word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // 处理用例：["abc", "ab"]
            if (word1.startsWith(word2) && !word1.equals(word2)) {
                return "";
            }

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                // 比较前一个和后一个，逐个字符比较，如果后一个和前一个的不相等，则相当于后一个的顺序大于前一个
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (!graph.get(word1.charAt(j)).contains(word2.charAt(j))) {
                        graph.get(word1.charAt(j)).add(word2.charAt(j));
                        inDegrees.put(word2.charAt(j), inDegrees.get(word2.charAt(j)) + 1);
                    }

                    break;
                }
            }
        }

        // 拓扑排序
        Queue<Character> queue = new LinkedList<>();
        for (char ch: inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);

            for (char neighbor: graph.get(ch)) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);

                if (inDegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
