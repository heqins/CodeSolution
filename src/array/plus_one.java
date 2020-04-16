/**
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
**/

import java.util.Arrays;

public class plus_one {
    public static int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        if (digits[0] == 10 && digits.length == 1) {
            return newArr(digits);
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0 ) break;
                digits[i] = 0;
                digits[i - 1] += 1;
            }
        }

        if (digits[0] == 10) {
            return newArr(digits);
        }

        return digits;
    }

    public static int[] newArr(int[] digits) {
        int[] temp = new int[digits.length+1];
        System.arraycopy(digits, 0, temp, 0, digits.length);
        temp[0] = 1;
        temp[1] = 0;
        System.out.println(Arrays.toString(temp));
        return temp;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
