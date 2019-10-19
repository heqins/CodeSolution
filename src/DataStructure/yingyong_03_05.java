package DataStructure;

public class yingyong_03_05 {
    public static void solution(int[][] array) {
        int[] max = new int[array.length];
        int[] min = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max[i]) {
                    max[i] = array[i][j];
                }
            }
        }

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] < min[i]) {
                    min[i] = array[j][i];
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(max[i] == min[j]) {
                    System.out.println("i: " + (i + 1) + ", j: " + (j + 1));
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Not Found!");
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0, -1, 2}, {0, 0, 2}, {1, -1, -1}};
        solution(array);
    }
}
