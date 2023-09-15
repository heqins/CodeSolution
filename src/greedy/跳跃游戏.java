package greedy;

public class 跳跃游戏 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 贪心：每一步看下当前的覆盖覆盖，如果最终覆盖范围包含最终节点则能够到达
     * @param nums
     * @return
     */
    public static boolean solve(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
