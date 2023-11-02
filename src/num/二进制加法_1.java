package num;

public class 二进制加法_1 {

    /**
     * 题目：输入两个表示二进制的字符串，请计算它们的和，
     * 并以二进制字符串的形式输出。例如，输入的二进制字符串分别是"11"和"10"，则输出"101"。
     * @param args
     */
    public static void main(String[] args) {
        String add = add("111", "111");
        System.out.println(add);
    }

    public static String add(String left, String right) {
        StringBuilder sb = new StringBuilder();
        int i = left.length() - 1;
        int j = right.length() - 1;
        int current = 0;
        while (i >= 0 && j >= 0) {
            int digitA = i >= 0 ? left.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? right.charAt(j--) - '0' : 0;

            int sum = digitA + digitB + current;
            current = sum >= 2 ? 1 : 0;
            // sum - 2是因为这一位上最多进位两个
            sb.append(sum >= 2 ? sum - 2 : sum);
        }

        // 进位
        if (current == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
