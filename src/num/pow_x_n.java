/**
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000

Example 2:

Input: 2.10000, 3
Output: 9.26100

Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:

    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]


**/

// 考虑要全面，边界情况
public class pow_x_n {
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            // -2147483648 is Integer.MIN_VALUE, and Integer.MAX_VALUE is 2147483647
            // so n = -n have no sense when n = -2147483648
            if (n == Integer.MIN_VALUE) {
                n += 2;
            }
            n = -n;
            x = 1/x;
        }
        return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(-1.0, -2147483648));
        System.out.println(Math.pow(-1.0, Integer.MIN_VALUE + 2));
    }
}
