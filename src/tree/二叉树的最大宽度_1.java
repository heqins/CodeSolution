package tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大宽度_1 {
    /**
     * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
     * 树的 最大宽度 是所有层中最大的 宽度 。
     * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
     * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
     * 题目数据保证答案将会在  32 位 带符号整数范围内。
     */
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList();
        // 赋予每个节点编号，利用子孩子节点编号为2*n,右孩子节点编号为2*n+1来计算宽度
        // 每层的宽度为最左边孩子的编号和最右边孩子的编号之差
        root.value = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int startIndex = 0;
            int endIndex = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    startIndex = node.value;
                }

                if (i == size - 1) {
                    endIndex = node.value;
                }

                if (node.left != null) {
                    queue.add(new TreeNode(2 * node.value, node.left.left, node.left.right));
                }

                if (node.right != null) {
                    queue.add(new TreeNode(2 * node.value + 1, node.right.left, node.right.right));
                }
            }

            result = Math.max(endIndex - startIndex + 1, result);
        }

        return result;
    }
}
