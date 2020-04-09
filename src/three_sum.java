/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
**/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length < 3 || nums == null) {
            return res;
        }

        HashSet<List<Integer>> hset = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            int mid = i + 1;
            int end = nums.length - 1;
            while (mid < end) {
                ArrayList<Integer> temp = new ArrayList<>();
                int sum = nums[i] + nums[mid] + nums[end];
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[mid]);
                    temp.add(nums[end]);

                    if(!hset.contains(temp)) {
                        hset.add(temp);
                        res.add(temp);
                    }
                    mid++;
                    end--;
                }else if (sum > 0) {
                    end--;
                }else {
                    mid++;
                }
            }
        }
        return res;
    }
}
