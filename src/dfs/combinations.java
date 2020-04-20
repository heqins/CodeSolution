/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
**/

/**
这道题让求1到n共n个数字里k个数的组合数的所有情况，还是要用深度优先搜索DFS来解，根据以往的经验，像这种要求出所有结果的集合，

一般都是用DFS调用递归来解。那么我们建立一个保存最终结果的大集合res，还要定义一个保存每一个组合的小集合out，

每次放一个数到out里，如果out里数个数到了k个，则把out保存到最终结果中，否则在下一层中继续调用递归。

网友u010500263的博客里有一张图很好的说明了递归调用的顺序，请点击这里。根据上面分析，可写出代码如下：

**/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        helper(combinations, new Stack<Integer>(), n, k, 1);
        return combinations;
    }
    
    private void helper(List<List<Integer>> res, Stack<Integer> path, int n, int k, int index) {
        if (k == 0) {
            List<Integer> list = new ArrayList(path);
            res.add(list);
            return;
        }
        for (int i = index; i <= n; i++) {
            path.push(i);
            helper(res, path, n, k-1, i+1);
            path.pop();
        }
    }
}
