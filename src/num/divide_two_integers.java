/**
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
**/

/**
这道题让我们求两数相除，而且规定不能用乘法，除法和取余操作，那么这里可以用另一神器位操作 Bit Manipulation，

思路是，如果被除数大于或等于除数，则进行如下循环，定义变量t等于除数，定义计数p，当t的两倍小于等于被除数时，

进行如下循环，t扩大一倍，p扩大一倍，然后更新 res 和m。这道题的 OJ 给的一些 test case 非常的讨厌，因为输入的都是 int 型，

比如被除数是 -2147483648，在 int 范围内，当除数是  -1 时，结果就超出了 int 范围，需要返回 INT_MAX，所以对于这种情况就在开始用 if 判定，

将其和除数为0的情况放一起判定，返回 INT_MAX。然后还要根据被除数和除数的正负来确定返回值的正负，这里采用长整型 long 来完成所有的计算，

最后返回值乘以符号即可，代码如下：
**/

public class divide_two_integers {
    /**
     * 1. +,-
     * 2. yue界
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;

        long lres = divide(ldividend, ldivisor);
        if (lres > Integer.MAX_VALUE) {
            return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign == 1 ? (int)lres : -(int)lres;
    }

    public long divide(long ldividend, long ldivisor) {
        // Recursion exit condition
	if (ldividend < ldivisor) return 0;
	
	//  Find the largest multiple so that (divisor * multiple <= dividend), 
	//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	//  Think this as a binary search.
	 long sum = ldivisor;
	 long multiple = 1;
	 while ((sum+sum) <= ldividend) {
		sum += sum;
		multiple += multiple;
         }
	 //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	 return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        divide_two_integers dti = new divide_two_integers();
        System.out.println(dti.divide(8, 2));
    }
}
