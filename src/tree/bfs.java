package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(N)，空间复杂度：O(N)
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        List<Integer> result = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            result.add(current.value);

            if (current.left != null) {
                nodeQueue.offer(current.left);
            }

            if (current.right != null) {
                nodeQueue.offer(current.right);
            }
        }

        return result;
    }
}
