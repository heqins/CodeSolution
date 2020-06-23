/**
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

提示：

    2 <= n <= 58

注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

/**
 * 剪绳子
 * 动态规划解法
 * @Author rex
 * 2018/7/20
 */
class Solution {
    /**
     * 动态规划剪绳子
     * @param n 绳子长度
     * @return
     */
    public int cutRopeByDP(int n) {
        //异常处理
        if(n < 0) {
            throw new IllegalArgumentException("Illegal Paramters");
        }
        // 得到绳子长度为1-3的显然的最优解
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }

        //创建数组存储子问题最优解
        int[] result = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            result[i] = i;
        }
        // 开始求解每一个绳子长度的最优解
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp = result[j] * result[i - j];
                if (temp > max) {
                    max = temp;
                }
            }
            result[i] = max;
        }
        return result[n];
    }
}

/**
 * 剪绳子
 * 贪婪算法解法
 * @Author rex
 * 2018/7/20
 */
public class Solution1 {
    /**
     * 贪婪算法剪绳子
     * @param n 绳子长度
     * @return
     */
    public int cutRopeByGA(int n) {
        //异常处理
        if(n < 0) {
            throw new IllegalArgumentException("Illegal Paramters");
        }
        // 得到绳子长度为1-3的显然的最优解
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }

        int timesOfThree = n/3;


        if (n%3 == 1) {
            timesOfThree--;
        }
        int timesOfTwo = (n - timesOfThree * 3)/2;

        return (int) (Math.pow(3,timesOfThree) * Math.pow(2, timesOfTwo));

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.cutRopeByGA(9));
    }
}
