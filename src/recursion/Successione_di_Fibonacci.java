/**
 * 最简单的递归
 * 没有考虑时间复杂度
 * @Author rex
 * 2018/7/15
 */
public class Solution {
    // 很垃圾
    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}

// 优化
public class Solution {
  public int Fibonacci(int n)
  {
    if (n < 2) return n;
    
    int pre1 = 0;
    int pre2 = 1;
    int sum = 0;
    for (int i = 2; i <= n; i++)
    {
      sum = pre1 + pre2;
      pre1 = pre2;
      pre2 = sum;
    }
    
    return sum;
  }
}
