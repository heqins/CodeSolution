package str;

public class 有效的回文 {

    /**
     * 题目：给定一个字符串，请判断它是不是回文。假设只需要考
     * 虑字母和数字字符，并忽略大小写。例如，"Was it a cat I
     * saw？"是一个回文字符串，而"race a car"不是回文字符串。
     * @param args
     */
    public static void main(String[] args) {
        boolean valid = isValid("Was it a cat I\n" +
                "     * saw？");

        System.out.println(valid);
    }

    public static boolean isValid(String word) {
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(word.charAt(i))){
                i++;
            } else if (!Character.isLetterOrDigit(word.charAt(j))) {
                j--;
            }else {
                if (Character.toLowerCase(word.charAt(i)) != Character.toLowerCase(word.charAt(j))) {
                    return false;
                }

                i++;
                j--;
            }
        }

        return true;
    }
}
