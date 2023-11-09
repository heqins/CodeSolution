package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中每层的最大值_1 {

    /**
     * 题目：输入一棵二叉树，请找出二叉树中每层的最大值。例
     * 如，输入图7.4中的二叉树，返回各层节点的最大值[3，4，9]。
     * @param args
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<Integer> result = findMax(root);

        return result;
    }

    public List<Integer> findMax(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> result = new ArrayList();
        while (!queue.isEmpty()) {
            int size = queue.size();

            int tempMax = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                tempMax = Math.max(temp.value, tempMax);

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            result.add(tempMax);
        }

        return result;
    }
}
