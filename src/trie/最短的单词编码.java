package trie;

public class 最短的单词编码 {

    /**
     * 65：最短的单词编码
     * 题目：输入一个包含n个单词的数组，可以把它们编码成一个字
     * 符串和n个下标。例如，单词数组["time"，"me"，"bell"]可以编码
     * 成一个字符串"time＃bell＃"，然后这些单词就可以通过下标[0，
     * 2，5]得到。对于每个下标，都可以从编码得到的字符串中相应的位
     * 置开始扫描，直到遇到'＃'字符前所经过的子字符串为单词数组中
     * 的一个单词。例如，从"time＃bell＃"下标为2的位置开始扫描，直
     * 到遇到'＃'前经过子字符串"me"是给定单词数组的第2个单词。给定
     * 一个单词数组，请问按照上述规则把这些单词编码之后得到的最短
     * 字符串的长度是多少？如果输入的是字符串数组
     * ["time"，"me"，"bell"]，那么编码之后最短的字符串是"time＃
     * bell＃"，长度是10。
     * @param args
     */
    public static void main(String[] args) {
        minimumLength(new String[]{"time", "me", "bell"});
    }

    public static int minimumLength(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = {0};

        // 从1开始的话，就包含#的长度了
        dfs(root, total, 1);

        return total[0];
    }

    /**
     * 反过来的前缀树
     * @param words
     * @return
     */
    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(26);
        for (String word: words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode(26);
                }

                node = node.children[ch - 'a'];
            }
        }

        return root;
    }

    public static void dfs(TrieNode root, int[] total, int length) {
        boolean isLeaf = true;

        for (TrieNode child: root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, total, length + 1);
            }
        }

        if (isLeaf) {
            total[0] += length;
        }
    }
}
