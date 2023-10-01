package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
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
        queue.offer(root);

        i = 1;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
    }
}
