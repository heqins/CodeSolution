package array;

public class 删除有序数组中的重复项2 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */

    // 对于此类问题，我们应该进行如下考虑：
    //
    // 由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留
    // 对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留
    //
    //作者：宫水三叶
    //链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/702970/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    // 假设当前遍历位置为i，写指针的可写入位置为current+1，对于i处的值，其写入的条件是重复小于等于2次，我们考虑已经写入的最后两位current和current-1，这两个位置的情况有两个，相等和不相等，首先考虑相等的情况，此时若i处的值和current-1或者说current处的值相同，那么，i处的值肯定不能加入；然后考虑不相等的情况，即current-1和current处值不相等，那么i处的值无论为什么，都满足题意的，即可以加入
    //
    //作者：裸奔丶小馒头
    //链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/5614/zhi-jie-bian-li-yi-ci-ji-ke-by-luo-ben-zhu-xiao-ma/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num: nums) {
            if (i < 2 || nums[i - 2] != num) {
                nums[i++] = num;
            }
        }

        return i;
    }
}
