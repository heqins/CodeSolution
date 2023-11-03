package array;

import java.util.Arrays;

public class 库存管理3 {

    /**
     * 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。
     * 请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
     */
    public int[] inventoryManagement(int[] stock, int cnt) {
        if (stock == null || stock.length == 0) {
            return new int[]{-1, -1};
        }

        quickSort(stock, 0, stock.length - 1);

        return Arrays.copyOf(stock, cnt);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 找到划分点
            quickSort(arr, low, pivotIndex - 1); // 递归排序左子数组
            quickSort(arr, pivotIndex + 1, high); // 递归排序右子数组
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择数组最后一个元素作为基准值
        int i = low - 1; // 初始化较小元素的索引

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // 交换 arr[i] 和 arr[j]
            }
        }

        swap(arr, i + 1, high); // 将基准值移到正确的位置
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
