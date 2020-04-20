/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
**/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), nums, nums.length, 0);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int k, int start) {
        if(k == 0) {
            result.add(new ArrayList<Integer>(list));
        }else {
            for(int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                helper(result, list, nums, k - 1, i + 1);
                list.remove(list.size() - 1);
            }
            // 用来添加空集合？
            result.add(new ArrayList<Integer>(list));
        }
    }
}
