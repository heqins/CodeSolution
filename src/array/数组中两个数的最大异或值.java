package array;

public class 数组中两个数的最大异或值 {

    /**
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     */
    class TrieNode {
        private TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        TrieNode root = buildTrie(nums);
        int result = 0;

        for (int num: nums) {
            TrieNode node = root;
            // 初始最大异或值为0
            int xor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.children[1 - bit] != null) {
                    // 每次都去找有没有和当前位相反的节点，如果有则走对应路径，结果累加
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                }else {
                    xor = xor << 1;
                    node = node.children[bit];
                }

                result = Math.max(result, xor);
            }
        }

        return result;
    }

    public TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();

        for (int num: nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }

                node = node.children[bit];
            }
        }

        return root;
    }
}
