public class reverse_integer {
    public int reverse(int x) {
        int y=0;
        for(;x!=0;x/=10){
            if (y>Integer.MAX_VALUE/10 || y<Integer.MIN_VALUE/10) return 0;
            y= 10*y + x%10;
        }
        return y;
    }

    public static void main(String[] args) {
        int test = 1534236469;
        reverse_integer ri = new reverse_integer();
        System.out.println(ri.reverse(test));
    }
}
