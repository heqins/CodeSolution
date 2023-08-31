package graph;

public class 相似的字符串 {

    /**
     * 题目：如果交换字符串X中的两个字符就能得到字符串Y，那么
     * 两个字符串X和Y相似。例如，字符串"tars"和"rats"相似（交换下
     * 标为0和2的两个字符）、字符串"rats"和"arts"相似（交换下标为0
     * 和1的字符），但字符串"star"和"tars"不相似。
     * 输入一个字符串数组，根据字符串的相似性分组，请问能把输
     * 入数组分成几组？如果一个字符串至少和一组字符串中的一个相
     * 似，那么它就可以放到该组中。假设输入数组中的所有字符串的长
     * 度相同并且两两互为变位词。例如，输入数组为
     * ["tars"，"rats"，"arts"，"star"]，可以分成两组，一组为
     * {"tars"，"rats"，"arts"}，另一组为{"star"}。
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"tars", "rats", "arts", "star"};
        System.out.println(solve(words));
    }

    public static int solve(String[] words) {
        int[] fathers = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fathers[i] = i;
        }

        int count = words.length;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (similar(words[i], words[j]) && union(fathers, i, j)) {
                    count--;
                }
            }
        }

        return count;
    }

    public static boolean similar(String x, String y) {
        int diffCount = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount <= 2;
    }

    public static boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFathers(fathers, i);
        int fatherOfJ = findFathers(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }

        return false;
    }

    public static int findFathers(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFathers(fathers, fathers[i]);
        }

        return fathers[i];
    }
}
