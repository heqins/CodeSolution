package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class yingyong_02_08 {
    public int test() {
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNext("#")) {
            s.push(scan.nextInt());
        }

        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        yingyong_02_08 y0208 = new yingyong_02_08();
        System.out.println(y0208.test());
    }
}
