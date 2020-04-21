/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
**/

List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            dfs(0, i, nums, new ArrayList<Integer>());
        }
        return res;
    }
    
    private void dfs(int start, int len, int[] nums, List<Integer> temp) {
        int count = temp.size();
        if (len == count) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (nums.length - start < len - count)
            return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            dfs(i+1, len, nums, temp);
            temp.remove(count);
        }
    }
