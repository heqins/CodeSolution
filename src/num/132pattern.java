/**

Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

这道题给我们了一个数组，让我们找到 132 的模式，就是第一个数小于第二第三个数，且第三个数小于第二个数。

当然最直接最暴力的方法，就是遍历所有的三个数字的组合，然后验证是否满足这个规律。得莫，OJ 说打妹。

那么就只能想办法去优化了，由于暴力搜索的时间复杂度是三次方，在之前的 3Sum 那道题中，我们也有把立方的复杂度减少到平方的复杂度，

相当于降了一维（降维打击么？），其实就是先固定一个数字，然后去遍历另外两个数字。我们先确定哪个数字呢，当然是最小的那个啦，

我们维护一个变量 mn，初始化为整型最大值，然后在遍历数字的时候，每次用当前数字来更新 mn，然后我们判断，若 mn 为当前数字就跳过，

因为需要找到数字j的位置，数字j是大于数字i的，mn 表示的就是数字i。这样数字i和数字j都确定了之后，就要来遍历数字k了，

范围是从数组的最后一个位置到数字j之间，只要中间的任何一个数字满足题目要求的关系，就直接返回 true 即可，参见代码如下：
**/

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, mn = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mn = Math.min(nums[j], mn);
            
            if (mn == nums[j]) continue;
            
            for (int k = n - 1; k > j; k--) {
                if (mn < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int two = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < two) {
                return true;
            }else {
                while (!stack.isEmpty() && nums[i] > stack.peekFirst()) {
                    two = stack.pollFirst();
                }
                stack.offerFirst(nums[i]);
            }
        }
        
        return false;
    }
}

/**
我们需要找到这样三个数
 
one < two < third
  
其中third 是最大的
 
我们从后往前遍历
 
我们可以用stack来保存最大的数
 
two是比stack里面的数小的
 
如果这个时候我们往前遍历，发现一个比two更小的数，我们可以说我们找到了一个 132 pattern
 
 
*/
