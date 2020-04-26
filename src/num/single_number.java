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

/**
由于数字在计算机是以二进制存储的，每位上都是0或1，如果我们把两个相同的数字异或，0与0 '异或' 是0，1与1 '异或' 也是0，

那么我们会得到0。根据这个特点，我们把数组中所有的数字都 '异或' 起来，则每对相同的数字都会得0，

然后最后剩下来的数字就是那个只有1次的数字。这个方法确实很赞，但是感觉一般人不会往 '异或' 上想，绝对是为CS专业的同学设计的好题呀，赞一个~~ 

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
