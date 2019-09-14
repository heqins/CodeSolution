package DataStructure;

import java.util.Scanner;

public class yingyong_02_08 {
    public int test() {
        int sum = 0;
        Scanner s = new Scanner(System.in);
        while (!s.hasNext("#")) {
            sum += s.nextInt();
        }
        return sum;
    }

    public static void main(String[] args) {
        yingyong_02_08 y0208 = new yingyong_02_08();
        System.out.println(y0208.test());
    }
}
