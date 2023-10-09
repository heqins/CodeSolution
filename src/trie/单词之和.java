package trie;

public class 单词之和 {

    TrieNode root;

    /**
     * 题目：请设计实现一个类型MapSum，它有如下两个操作。
     * ● 函数insert，输入一个字符串和一个整数，在数据集合中添加一个
     * 字符串及其对应的值。如果数据集合中已经包含该字符串，则将该
     * 字符串对应的值替换成新值。
     * ● 函数sum，输入一个字符串，返回数据集合中所有以该字符串为
     * 前缀的字符串对应的值之和。
     */

    public void insert(String word, int val) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(26);
            }

            node = node.children[ch - 'a'];
        }

        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }

            node = node.children[ch - 'a'];
        }

        return getSum(node);
    }

    public int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }

        int result = node.val;
        for (TrieNode child: node.children) {
            result += getSum(child);
        }

        return result;
    }
}
