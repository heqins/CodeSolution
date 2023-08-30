package trie;

public class TrieNode {

    TrieNode[] children;

    Boolean isWord;

    Integer val;

    public TrieNode(int size) {
        children = new TrieNode[size];
    }
}
