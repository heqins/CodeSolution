import java.util.Arrays;

public class sort_colors {
    // dutch national flag problem
    public static void sortColors(int[] a) {
        int low = 0, high = a.length-1;

        for(int i = 0; i <= high; ) {
            if(a[i] == 0) {
                swap(a, low++, i);
                i++;
            }
            else if(a[i] == 1) {
                swap(a, low, i);
                i++;
            }
            else {
                swap(a, high--, i);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        if(i == j || a[i] == a[j])
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
