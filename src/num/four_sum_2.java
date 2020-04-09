/**
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
**/

/**
这道题是之前那道 4Sum 的延伸，让我们在四个数组中各取一个数字，使其和为0。那么坠傻的方法就是遍历所有的情况，时间复杂度为 O(n4)。

但是既然 Two Sum 那道都能将时间复杂度缩小一倍，那么这道题使用 HashMap 是否也能将时间复杂度降到 O(n2) 呢？

答案是肯定的，如果把A和B的两两之和都求出来，在 HashMap 中建立两数之和跟其出现次数之间的映射，那么再遍历C和D中任意两个数之和，只要看哈希表存不存在这两数之和的相反数就行了，参见代码如下：
**/

import java.util.HashMap;
import java.util.Map;

public class four_sum_2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sums = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                // api是containsKey
                if (sums.containsKey(sum)) {
                    sums.put(sum, sums.get(sum) + 1);
                } else {
                    sums.put(sum, 1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = -(C[i] + D[j]);
                if (sums.containsKey(sum)) {
                    count += sums.get(sum);
                }
            }
        }
        return count;
    }
}
