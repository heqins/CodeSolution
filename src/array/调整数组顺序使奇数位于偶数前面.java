/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。

 

提示：

    1 <= nums.length <= 50000
    1 <= nums[i] <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

/**
 * 调整数组顺序使奇数位于偶数前面
 * @Author rex
 * 2018/7/24
 */
 
public class Solution1 {
    /**
     * 只完成基本功能的解法
     * @param array
     */
    public void reOrderArray(int [] array) {
        // 防止特殊输入
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            // 第一个指针，直到遇见偶数，然后开始准备交换
            while (i < j && (array[i] & 1) != 0) {
                i++;
            }
            // 第二个指针，直到遇见奇数，然后开始准备交换
            while (i < j && (array[j] & 1) == 0) {
                j--;
            }
            // 开始交换
            if (i < j) {
                swapArray(array, i, j);
            }
        }
    }

    /**
     * 交换数组的两个值
     * @param array
     * @param i
     * @param j
     */
    public void swapArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
