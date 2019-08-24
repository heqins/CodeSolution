package Array;

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
