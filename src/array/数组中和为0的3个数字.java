package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 数组中和为0的3个数字 {

    /**
     * 题目：输入一个数组，如何找出数组中所有和为0的3个数字的三元组？
     * 需要注意的是，返回值中不得包含重复的三元组。例如，在数组[-1，0，1，2，-1，-4]中有两个三元组的和为0，
     * 它们分别是[-1，0，1]和[-1，-1，2]。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int target = 0;

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length > 3) {
//            int i = 0;
//            while (i < nums.length / 2) {
//                List<Integer> temp = find(nums, target, i);
//                if (temp != null) {
//                    result.add(temp);
//                }
//
//                i++;
//            }

            for (int i = 1; i < nums.length - 1; i++) {
                List<Integer> temp = find(nums, target, i);
                if (temp != null) {
                    result.add(temp);
                }
            }
        }

        System.out.println("test");
    }

    public static List<Integer> find(int[] nums, int target, int index) {
        int i = 0;
        int j = nums.length - 1;

        while (i < index && j > index) {
            int sum = nums[i] + nums[index] + nums[j];
            if (sum == target) {
                return Arrays.asList(nums[i], nums[j], nums[index]);
            }else if (sum < target) {
                i++;
            }else {
                j--;
            }
        }

        return null;
    }
}
