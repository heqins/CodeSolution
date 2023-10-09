package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 前k个高频元素 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1,4};
        topKFrequent(nums, 2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        // buckets的索引被映射为数组统计的频率了，那么越往后的索引对应的数频率越高
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num: map.keySet()) {
            // i就是频率
            int i = map.get(num);

            if (buckets[i] == null) {
                buckets[i] = new ArrayList();
            }

            buckets[i].add(num);
        }

        int count = 0;

        // i要从nums.length开始，因为前面buckets存储的是频率

        for (int i = nums.length; i > 0; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    if (count >= k) {
                        break;
                    }

                    result[count++] = buckets[i].get(j);
                }
            }
        }

        return result;
    }
}
