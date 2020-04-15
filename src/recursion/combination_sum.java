/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
**/

import java.util.ArrayList;
import java.util.List;

public class combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target < 0 || candidates == null) return res;

        helper(res, new ArrayList<>(), candidates, target, 0, 0);

        return res;
    }

    public void helper(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
        }else {
            for (int i = 0; i < start; i++) {
                combination.add(candidates[i]);
                helper(combinations, combination, candidates, target, sum + candidates[i], i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
