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
