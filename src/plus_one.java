import java.util.Arrays;

public class plus_one {
    public static int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        if (digits[0] == 10 && digits.length == 1) {
            return newArr(digits);
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0 ) break;
                digits[i] = 0;
                digits[i - 1] += 1;
            }
        }

        if (digits[0] == 10) {
            return newArr(digits);
        }

        return digits;
    }

    public static int[] newArr(int[] digits) {
        int[] temp = new int[digits.length+1];
        System.arraycopy(digits, 0, temp, 0, digits.length);
        temp[0] = 1;
        temp[1] = 0;
        System.out.println(Arrays.toString(temp));
        return temp;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
