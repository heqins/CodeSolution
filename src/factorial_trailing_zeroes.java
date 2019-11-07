public class factorial_trailing_zeroes {
    public static int trailingZeroes(int n) {
        // 返回阶乘的末尾有多少个0
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }
}
