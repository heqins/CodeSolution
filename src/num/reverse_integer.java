/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
**/

/**
翻转数字问题需要注意的就是溢出问题，看了许多网上的解法，由于之前的 OJ 没有对溢出进行测试，
所以网上很多人的解法没有处理溢出问题也能通过 OJ。现在 OJ 更新了溢出测试，所以还是要考虑到。
为什么会存在溢出问题呢，由于int型的数值范围是 -2147483648～2147483647， 那么如果要翻转 1000000009 这个在范围内的数得到 9000000001，
而翻转后的数就超过了范围。博主最开始的想法是，用 long 型数据，其数值范围为 -9223372036854775808~9223372036854775807， 
远大于 int 型这样就不会出现溢出问题。但实际上 OJ 给出的官方解答并不需要使用 long，一看比自己的写的更精简一些，它没有特意处理正负号，
仔细一想，果然正负号不影响计算，而且没有用 long 型数据，感觉写的更好一些，那么就贴出来吧：
**/

public class reverse_integer {
    public int reverse(int x) {
        int y=0;
        for(;x!=0;x/=10){
            // 注意要/10
            if (y>Integer.MAX_VALUE/10 || y<Integer.MIN_VALUE/10) return 0;
            y= 10*y + x%10;
        }
        return y;
    }

    public static void main(String[] args) {
        int test = 1534236469;
        reverse_integer ri = new reverse_integer();
        System.out.println(ri.reverse(test));
    }
}
