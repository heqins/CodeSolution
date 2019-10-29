package DP;

public class climbing_stairs {
    public int climbStairs2(int n) {
        return climb_stairs(0, n);
    }

    public int climb_stairs(int i, int n) {
        // Time Exceed
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }
        return climb_stairs(i + 1, n) + climb_stairs(i + 2, n);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // save all caculated values
        dp[0] = 1; // base case
        dp[1] = 1; // base case
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
        /**
         * int[] dp = new int[n + 1]; // save all caculated values
         * dp[0] = 1; // base case
         * dp[1] = 1; // base case
         * for (int i = 2; i <= n; i++) {
             *dp[i] = dp[i - 1] + dp[i - 2];
         *  }
         *  return dp[n];
         *  }
         */
    
    public static void main(String[] args) {
        climbing_stairs cs = new climbing_stairs();
        System.out.println(cs.climbStairs(44));
    }
}
