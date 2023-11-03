package array;

import java.util.*;

public class 优势洗牌 {

    /**
     * 给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
     *
     * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
     * 输出：[2,11,7,15]
     * 示例 2：
     *
     * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
     * 输出：[24,32,8,12]
     *
     *
     * 提示：
     *
     * 1 <= nums1.length <= 105
     * nums2.length == nums1.length
     * 0 <= nums1[i], nums2[i] <= 109
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }
        Arrays.sort(nums1); Arrays.sort(nums2);
        int[] ans = new int[n];

        for (int l1 = 0, l2 = 0, r2 = n - 1; l1 < n; l1++) {
            int t = nums1[l1] > nums2[l2] ? l2 : r2;
            List<Integer> list = map.get(nums2[t]);
            int idx = list.remove(list.size() - 1);
            ans[idx] = nums1[l1];
            if (t == l2) {
                l2++;
            }
            else {
                r2--;
            }
        }

        return ans;
    }
}
