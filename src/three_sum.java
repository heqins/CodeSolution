/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
**/

/**
这道题让我们求三数之和，比之前那道 Two Sum 要复杂一些，博主考虑过先 fix 一个数，然后另外两个数使用 Two Sum 那种 HashMap 的解法，但是会有重复结果出现，就算使用 TreeSet 来去除重复也不行，会 TLE，看来此题并不是考 Two Sum 的解法。来分析一下这道题的特点，要找出三个数且和为0，那么除了三个数全是0的情况之外，肯定会有负数和正数，还是要先 fix 一个数，然后去找另外两个数，只要找到两个数且和为第一个 fix 数的相反数就行了，既然另外两个数不能使用 Two Sum 的那种解法来找，如何能更有效的定位呢？我们肯定不希望遍历所有两个数的组合吧，所以如果数组是有序的，那么就可以用双指针以线性时间复杂度来遍历所有满足题意的两个数组合。

对原数组进行排序，然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了。

这里可以先做个剪枝优化，就是当遍历到正数的时候就 break，为啥呢，因为数组现在是有序的了，如果第一个要 fix 的数就是正数了，

则后面的数字就都是正数，就永远不会出现和为0的情况了。然后还要加上重复就跳过的处理，处理方法是从第二个数开始，如果和前面的数字相等，

就跳过，因为不想把相同的数字fix两次。对于遍历到的数，用0减去这个 fix 的数得到一个 target，然后只需要再之后找到两个数之和等于 target 即可。

用两个指针分别指向 fix 数字之后开始的数组首尾两个数，如果两个数和正好为 target，则将这两个数和 fix 的数一起存入结果中。

然后就是跳过重复数字的步骤了，两个指针都需要检测重复数字。如果两数之和小于 target，则将左边那个指针i右移一位，使得指向的数字增大一些。

同理，如果两数之和大于 target，则将右边那个指针j左移一位，使得指向的数字减小一些，代码如下：

或者我们也可以利用 TreeSet 的不能包含重复项的特点来防止重复项的产生，那么就不需要检测数字是否被 fix 过两次，

不过个人觉得还是前面那种解法更好一些，参见代码如下：
**/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length < 3 || nums == null) {
            return res;
        }

        HashSet<List<Integer>> hset = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            int mid = i + 1;
            int end = nums.length - 1;
            while (mid < end) {
                ArrayList<Integer> temp = new ArrayList<>();
                int sum = nums[i] + nums[mid] + nums[end];
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[mid]);
                    temp.add(nums[end]);

                    if(!hset.contains(temp)) {
                        hset.add(temp);
                        res.add(temp);
                    }
                    mid++;
                    end--;
                }else if (sum > 0) {
                    end--;
                }else {
                    mid++;
                }
            }
        }
        return res;
    }
}
