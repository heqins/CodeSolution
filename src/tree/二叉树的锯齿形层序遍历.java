package tree;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int flag = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                temp.add(node.value);
            }

            if (flag % 2 == 0) {
                Collections.reverse(temp);
            }

            result.add(new ArrayList(temp));

            flag++;
        }

        return result;
    }
}
