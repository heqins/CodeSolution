package str;

import java.util.ArrayList;
import java.util.List;

public class 字典序排数 {

    /**
     * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
     *
     * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();

        for (int i = 1; i <= 9; i++) {
            helper(result, n, i);
        }

        return result;
    }

    public void helper(List<Integer> result, int n, int num) {
        if (num > n) {
            return;
        }

        result.add(num);

        for (int i = 0; i <= 9; i++) {
            helper(result, n, num * 10 + i);
        }
    }

    // 时间复杂度：本质上在搜索一棵节点数量为 nnn 的多阶树（形态类似于字典树），复杂度为 O(n)O(n)O(n)
    //空间复杂度：忽略递归带来的额外空间开销，复杂度为 O(1)O(1)O(1)
    //
    //作者：宫水三叶
    //链接：https://leetcode.cn/problems/lexicographical-numbers/solutions/1429918/by-ac_oier-ktn7/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public List<Integer> lexicalOrder2(int n) {
        // 非递归方式
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return ans;
    }

}
