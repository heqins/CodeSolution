package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */

    private static List<List<Integer>> res = new LinkedList();
    private static List<Integer> path = new LinkedList();

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println("test");
    }

    public static List<List<Integer>> combine(int n, int k) {
        helper(1, n, k);

        return res;
    }

    public static void helper(int current, int n, int k) {
        // 不要出现current>n,因为这样会拦截部分情况，这个时候current迭代到5了，path里有2个值，应该加入到res里
        if (k == path.size()) {
            res.add(new ArrayList(path));
            return;
        }


        for (int i = current; i <= n; i++) {
            path.add(i);

            helper(i + 1, n, k);

            path.remove(path.size() - 1);
        }
    }
}
