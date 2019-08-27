package Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letter_combinations_of_phone_number {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combinations, String next_digit) {
        if (next_digit.length() == 0) {
            output.add(combinations);
        }
        else {
            String digit = next_digit.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // next_digit.substring(1) == next_digit[1:]
                backtrack(combinations + letter, next_digit.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        letter_combinations_of_phone_number lc = new letter_combinations_of_phone_number();
        System.out.println("234123".substring(1));
        System.out.println(lc.letterCombinations("23"));
    }
}
