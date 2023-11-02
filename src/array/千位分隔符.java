package array;

public class 千位分隔符 {

    public static void main(String[] args) {
        System.out.println(solve(100000000));
    }

    public static String solve(int num) {
        char[] chs = String.valueOf(num).toCharArray();

        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            sb.append(chs[i]);

            if (count % 3 == 0 && i != 0) {
                sb.append(",");
            }

            count++;
        }

        return sb.reverse().toString();
    }
}
