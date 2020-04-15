/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
**/
public class jump_game {
    // greedy algorithm
    /**
    其实这题最好的解法不是 DP，而是贪婪算法 Greedy Algorithm，因为这里并不是很关心每一个位置上的剩余步数，
    
    而只希望知道能否到达末尾，也就是说我们只对最远能到达的位置感兴趣，所以维护一个变量 reach，表示最远能到达的位置，
    
    初始化为0。遍历数组中每一个数字，如果当前坐标大于 reach 或者 reach 已经抵达最后一个位置则跳出循环，
    
    否则就更新 reach 的值为其和 i + nums[i] 中的较大值，其中 i + nums[i] 表示当前位置能到达的最大位置，参见代码如下：
    **/
  
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        jump_game jg = new jump_game();
        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
