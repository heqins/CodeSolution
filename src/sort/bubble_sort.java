package Sort;

public class bubble_sort {
    public void sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 6, 0, -1, 3, -10, 24, -100};
        bubble_sort bs = new bubble_sort();
        bs.sort(test);
        for (int i: test) {
            System.out.println(i);
        }
    }
}
