import java.util.LinkedList;
import java.util.Queue;

public class symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && helper(t1.left, t2.right)
                && helper(t1.right, t2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        return compareTwoNodes(root.left, root.right);
    }

    public boolean compareTwoNodes(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        else if (p == null | q == null) return false;
        else if (p.val == q.val) return compareTwoNodes(p.left, q.right) && compareTwoNodes(p.right, q.left);
        return false;
    }
}
