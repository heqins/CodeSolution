public class divide_two_integers {
    /**
     * 1. +,-
     * 2. yue界
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;

        long lres = divide(ldividend, ldivisor);
        if (lres > Integer.MAX_VALUE) {
            return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign == 1 ? (int)lres : -(int)lres;
    }

    public long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        divide_two_integers dti = new divide_two_integers();
        System.out.println(dti.divide(8, 2));
    }
}
