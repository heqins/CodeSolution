package Array;

import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            int component = target - nums[j];
            if(map.containsKey(component) && map.get(component) != j) {
                return new int[]{j, map.get(component)};
            }
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 54, 12, 12};
        two_sum two = new two_sum();
        int[] result = two.twoSum(nums, 66);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
