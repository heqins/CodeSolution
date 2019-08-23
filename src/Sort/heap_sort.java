package Sort;

public class heap_sort {
    public void sort(int[] arrays) {
        create_heap(arrays);
    }

    public void create_heap(int[] arrays) {
        for (int i = arrays.length/2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arrays, i, arrays.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arrays.length - 1; j > 0; j--) {
            swap(arrays, 0, j);
            adjustHeap(arrays, 0, j);
        }
    }

    public void adjustHeap(int[] arrays, int i, int length) {
        int temp = arrays[i];
        for (int k = 2*i+1; k < length; k=2*k+1) {
            if (k+1 < length && arrays[k] < arrays[k+1]) {
                k++;
            }
            if (arrays[k] > temp) {
                arrays[i] = arrays[k];
                i = k;
            }
        }
        arrays[i] = temp;
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 6, 0, -1, 3, -10, 24, -100};
        heap_sort hs = new heap_sort();
        hs.sort(test);
        for (int i: test) {
            System.out.println(i);
        }
    }
}
