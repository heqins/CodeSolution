public class pow_x_n {
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            // -2147483648 is Integer.MIN_VALUE, and Integer.MAX_VALUE is 2147483647
            // so n = -n have no sense when n = -2147483648
            if (n == Integer.MIN_VALUE) {
                n += 2;
            }
            n = -n;
            x = 1/x;
        }
        return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(-1.0, -2147483648));
        System.out.println(Math.pow(-1.0, Integer.MIN_VALUE + 2));
    }
}
