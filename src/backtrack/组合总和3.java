package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 组合总和3 {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     *
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();

        helper(res, path, 1, k, n);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> path,
                       int start, int k, int n) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList(path));
                return;
            }
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);

            helper(res, path, i + 1, k, n - i);

            path.remove(path.size() - 1);
        }
    }
}
