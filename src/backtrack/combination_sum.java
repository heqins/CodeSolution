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

        helper(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
