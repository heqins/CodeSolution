public class add_strings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder s = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int n1 = i < 0 ? 0 : num1.charAt(i--) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = n1 + n2 + carry;
            s.append(sum % 10);
            carry = sum > 9 ? 1 : 0;
        }

        if (carry > 0) {
            s.append(1);
        }

        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        add_strings as = new add_strings();
        System.out.println(as.addStrings(num1, num2));
    }
}
