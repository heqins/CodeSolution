package DataStructure;

public class yingyong_03_05 {
    public static void solution(int[][] array) {
        int[] max = new int[array.length];
        int[] min = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            max[i] = -1;
            min[i] = ~(0) >> 1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max[i]) {
                    max[i] = array[i][j];
                }
                if (array[i][j] < min[j]) {
                    min[j] = array[i][j];
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(max[i] == min[j]) {
                    System.out.println("i: " + (i + 1) + ", j: " + (j + 1));
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Not Found!");
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{11, 3, 5, 6, 9}, {12, 4, 7, 8, 10}, {10, 5, 6, 9, 11}, {8, 6, 4, 7, 2}, {15, 10, 11, 20, 25}};
        solution(array);
    }
}
