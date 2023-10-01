package tree;

import java.util.*;

public class 彩灯装饰记录2 {

    /**
     * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：
     *
     * 第一层按照从左到右的顺序记录
     * 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
     */
    public List<List<Integer>> decorateRecord(TreeNode root) {
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
