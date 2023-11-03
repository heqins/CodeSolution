package array;

public class 寻找两个正序数组的中位数_3 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            // 分为奇数和偶数的情况，如果是偶数，是中间两个数的平均数
            int m = find(nums1, 0, nums2, 0, len / 2);

            int n = find(nums1, 0, nums2, 0, len / 2 + 1);

            return (m + n) / 2.0;
        }else {
            return find(nums1, 0, nums2, 0, len / 2 + 1) * 1.0;
        }
    }

    // i和j分别代表区间的左端点
    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
        // 代表nums1的元素已经用完了，必定在nums2里
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }

        if (nums2.length == j) {
            return nums1[i + k - 1];
        }

        // 必需
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int si = Math.min(nums1.length, k / 2 + i);

        int sj = Math.min(nums2.length, k / 2 + j);

        System.out.println("si" + si + " sj" + sj);

        if (nums1[si - 1] < nums2[sj - 1]) {
            // 第k个数必然不在nums1的左区间，抛弃掉，并且k的个数减去相应区间
            return find(nums1, si, nums2, j, k - (si - i));
        }else {
            return find(nums1, i, nums2, sj, k - (sj - j));
        }
    }
}
