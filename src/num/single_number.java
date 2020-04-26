/**
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
**/

public class single_number {
    public int singleNumber(int[] nums) {
        // 异或： 相当于整个序列为0 ^ single number
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // ^ is XOR operator
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 2, 3, 3, 4, 4, 5};
        single_number sn = new single_number();
        System.out.println(sn.singleNumber(test));
//        System.out.println(4 ^ 4);
    }
}
