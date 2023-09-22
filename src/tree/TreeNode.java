package tree;

public class TreeNode {

    TreeNode left;

    TreeNode right;

    TreeNode parent;

    Integer value;

    public TreeNode(int val) {
        value = val;
    }

    public TreeNode(TreeNode left, TreeNode right, TreeNode parent, Integer value) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
