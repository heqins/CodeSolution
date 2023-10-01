package array;

import java.util.Random;

public class 打乱数组 {

    /**
     * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
     *
     * 实现 Solution class:
     *
     * Solution(int[] nums) 使用整数数组 nums 初始化对象
     * int[] reset() 重设数组到它的初始状态并返回
     * int[] shuffle() 返回数组随机打乱后的结果
     */
    private int[] res;
    private Random random;

    public 打乱数组(int[] nums) {
        this.res = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return this.res;
    }

    public int[] shuffle() {
        int[] nums = res.clone();

        for (int i = 0; i < nums.length; i++) {
            // Knuth洗牌算法，对于每个位置i，从[i, n]的位置随机选出一个来进行交换

//            int randomIndex = random.nextInt(i, nums.length);
//            int temp = nums[randomIndex];
//            nums[randomIndex] = nums[i];
//            nums[i] = temp;
        }

        return nums;
    }
}
