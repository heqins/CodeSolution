package num;

public class 只出现一次的数字2_2 {

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        int result = 0;

        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num = num >> 1;
            }
        }

        // 统计数字二进制的个数，将每个数字二进制位上对应数字相加，最后与3取模，保留下来的二进制就是出现1次的那个数字
        int size = 3;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            // 需要从右向左取
            result = result | counts[31 - i] % size;
        }

        return result;
    }
}
