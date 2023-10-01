package tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.value);

                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("null");
            }

            sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        String[] nodes = data.substring(1, data.length() - 1).split(",");

        Queue<TreeNode> queue = new LinkedList();
        int i = 0;

        if (nodes[i] == "null") {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
        i = 1;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;

                queue.offer(left);
            }

            i++;

            if (!nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;

                queue.offer(right);
            }

            i++;
        }

        return root;
    }
}
