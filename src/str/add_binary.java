/**
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
**/

public class add_binary {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();

        if (a.length() == 0 && b.length() == 0) {
            return "";
        } else if (a.length() == 0) {
            return b;
        }else if(b.length() == 0){
            return a;
        }

        int len_a = a.length() - 1;
        int len_b = b.length() - 1;
        int carry = 0;

        while (len_a >= 0 && len_b >= 0) {
            char char_A = a.charAt(len_a--);
            char char_B = b.charAt(len_b--);
            int num_a = char_A - '0';
            int num_b = char_B - '0';
            int sum = carry + num_a + num_b;
            s.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
        }

        while (len_a >= 0) {
            char char_A = a.charAt(len_a--);
            int num_a = char_A - '0';
            int sum = carry + num_a;
            s.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
        }

        while (len_b >= 0) {
            char char_B = b.charAt(len_b--);
            int num_b = char_B - '0';
            int sum = carry + num_b;
            s.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
        }
        
        // 不要忘了当每一位都进位后，会多出一位
        if (carry > 0) {
            s.append(1);
        }

        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "100";
        add_binary ab = new add_binary();
        System.out.println(ab.addBinary(num1, num2));
    }
}
