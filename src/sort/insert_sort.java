public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 依次遍历索引 i 之前的元素，直到找到合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
