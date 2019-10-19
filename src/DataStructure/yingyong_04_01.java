package DataStructure;

public class yingyong_04_01 {
    public static TreeNode createBTS(int[] array) {
        if (array.length == 0) {return null;}
        return helper(array, 0);
    }

    public static TreeNode helper(int[] array, int i) {
        if (i > array.length - 1) return null;
        TreeNode cur = new TreeNode(array[i]);
        cur.left = helper(array, 2 * i + 1);
        cur.right = helper(array, 2 * i + 2);
        return cur;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, 3 ,4};
        TreeNode root = createBTS(array);
        System.out.println(root.left.right.val);
    }
}
