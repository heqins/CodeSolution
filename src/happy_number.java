import java.util.ArrayList;
import java.util.List;

public class happy_number {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        return Happy(list, n);
    }

    public boolean Happy(List<Integer> list, int n) {
        int sum = 0;
        list.add(n);
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (sum == 1) {
            return true;
        }else if (list.contains(sum)){
            // return false when there is a cycle
            return false;
        }else {
            return Happy(list, sum);
        }
    }

    public static void main(String[] args) {
        int n = 19;
        happy_number hn = new happy_number();
        System.out.println(hn.isHappy(n));
    }
}
