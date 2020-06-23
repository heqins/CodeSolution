/**
请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

示例 2：

输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。

示例 3：

输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

 

注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/


public class number_of_1bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
         * << 左移运算符，num << 1,相当于num乘以2
         *
         * >> 右移运算符，num >> 1,相当于num除以2
         *
         * >>> 无符号右移，忽略符号位，空位都以0补齐
         */
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        number_of_1bits nob = new number_of_1bits();
        System.out.println(nob.hammingWeight(00000000000000000000000000001011));
    }
}
