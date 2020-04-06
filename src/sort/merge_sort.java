package Sort;

public class merge_sort {
    public void mergeSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    public void helper(int[] arrays, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        helper(arrays, left, mid);
        helper(arrays, mid + 1, right);
        merge(arrays, left, mid, right);
    }

    public void merge(int[] arrays, int left, int mid, int right) {
        int[] temp = new int[arrays.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        while (left <= mid && r1 <= right) {
            if (arrays[left] <= arrays[r1]) {
                temp[tIndex++] = arrays[left++];
            }else {
                temp[tIndex++] = arrays[r1++];
            }
        }
        while (left <= mid) {
            temp[tIndex++] = arrays[left++];
        }

        while (r1 <= right) {
            temp[tIndex++] = arrays[r1++];
        }

        while (cIndex <= right) {
            arrays[cIndex] = temp[cIndex];
            cIndex++;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 6, 0, -1, 3, -10, 24, -100};
        merge_sort ms = new merge_sort();
        ms.mergeSort(test);
        for (int i: test) {
            System.out.println(i);
        }
    }
}
