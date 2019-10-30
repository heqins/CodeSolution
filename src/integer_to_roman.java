public class integer_to_roman {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                s.append(numerals[i]);
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        integer_to_roman itr = new integer_to_roman();
        System.out.println(itr.intToRoman(12));
    }
}
