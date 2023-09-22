package trie;

public class 替换单词 {

    /**
     * 题目：英语中有一个概念叫词根。在词根后面加上若干字符就
     * 能拼出更长的单词。例如，"an"是一个词根，在它后面加
     * 上"other"就能得到另一个单词"another"。现在给定一个由词根组
     * 成的字典和一个英语句子，如果句子中的单词在字典中有它的词
     * 根，则用它的词根替换该单词；如果单词没有词根，则保留该单
     * 词。请输出替换后的句子。例如，如果词根字典包含字符串
     * ["cat"，"bat"，"rat"]，英语句子为"the cattle was rattled by
     * the battery"，则替换之后的句子是"the cat was rat by the
     * bat"。
     */
    public static void main(String[] args) {

    }

    public static String replacePrefix(TrieNode node, String sentence) {
        TrieNode root = node;
        StringBuilder sb = new StringBuilder();
        for (char ch: sentence.toCharArray()) {
            if (root.isWord || root.children[ch - 'a'] == null) {
                break;
            }

            sb.append(ch);
            root = root.children[ch - 'a'];
        }

        return root.isWord ? sb.toString() : "";
    }

    private TrieNode buildTrie(String[] strs) {
        TrieNode root = new TrieNode(26);
        for (String word: strs) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode(26);
                }

                node = node.children[ch - 'a'];
            }

            root.isWord = true;
        }

        return root;
    }
}
