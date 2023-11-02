package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树_1 {

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> tempList = new ArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                tempList.add(node.value);
            }

            result.add(tempList);
        }

        return result;
    }
}
