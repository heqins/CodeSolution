/**
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
**/
public class missing_number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumS = (n + 1) * n / 2;
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        return sumS - sum;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0 ,3 ,1 ,2 ,4, 5};
        missing_number mn = new missing_number();
        System.out.println(mn.missingNumber(test));
    }
}
