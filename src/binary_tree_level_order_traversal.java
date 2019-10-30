import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                temp.add(cur.val);
            }

            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
