package Sort;

public class select_sort {
    public void sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[min_index]) {
                    min_index = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[min_index];
            arrays[min_index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 6, 0, -1, 3, -10, 24, -100};
        select_sort ss = new select_sort();
        ss.sort(test);
        for (int i: test) {
            System.out.println(i);
        }
    }
}
