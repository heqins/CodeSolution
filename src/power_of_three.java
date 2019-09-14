public class power_of_three {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }else if (n <= 2) {
            return false;
        }

        while (n > 3) {
            if (n % 3 == 0) {
                n = n / 3;
            }else {
                return false;
            }
        }

        return n == 3;
    }

    public static void main(String[] args) {
        power_of_three pot = new power_of_three();
        System.out.println(pot.isPowerOfThree(9));
    }
}
