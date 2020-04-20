/**
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
**/

/**
然后我们来看看其他的解法，参考维基百科上关于格雷码的性质，

有一条是说镜面排列的，n位元的格雷码可以从n-1位元的格雷码以上下镜射后加上新位元的方式快速的得到，如下图所示一般。

**/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
              /**
              左移一位相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
              右移一位相当于除以2的1次方，右移n位就相当于除以2的n次方。
              比如
              10 << 1 = 20
              6 >> 1 = 3
              首先会将5转为2进制表示形式(java中，整数默认就是int类型,也就是32位):
              0000 0000 0000 0000 0000 0000 0000 0101           然后左移2位后，低位补0：
              **/
                list.add(list.get(j) | 1 << i);
            }
        }
        return list;
    }
}
