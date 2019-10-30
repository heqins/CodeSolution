public class sum_of_two_integers {
    public int getSum(int a, int b) {
        if (b > 0) {
            while (b != 0) {
                a++;
                b--;
            }
        }else {
            while (b != 0) {
                a--;
                b++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        sum_of_two_integers sti = new sum_of_two_integers();
        System.out.println(sti.getSum(2, 4));
    }
}
