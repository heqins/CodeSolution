public class sqrt {
    public static int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
