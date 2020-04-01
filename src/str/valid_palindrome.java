/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: fals
**/
public class valid_palindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            char left = Character.toLowerCase(array[i]);
            char right = Character.toLowerCase(array[j]);
            if (Character.isLetterOrDigit(left)) {
                if (Character.isLetterOrDigit(right)) {
                    if (left == right) {
                        i++;
                        j--;
                    }else{
                        return false;
                    }
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
