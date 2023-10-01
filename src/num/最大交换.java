package num;

public class 最大交换 {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     */
    public int maximumSwap(int num) {
        char[] chs = String.valueOf(num).toCharArray();

        // 从后往前，找到右边最大的一个数，将索引存储到arr数组中
        // 然后从前往后，找到第一个和最大数的索引不相等的那个，然后交换，这个就是交换1次后最大的那个数，
        // 因为需要把右边最大的那个数尽可能放到最左边
        int[] arr = new int[chs.length];

        int maxIndex = chs.length + 1;

        int max = -1;

        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] - '0' > max) {
                maxIndex = i;
                max = chs[i] - '0';
            }

            arr[i] = maxIndex;
        }

        for (int i = 0; i < chs.length; i++) {
            if (arr[i] != i && (chs[arr[i]] != chs[i])) {
                char temp = chs[arr[i]];
                chs[arr[i]] = chs[i];
                chs[i] = temp;

                break;
            }
        }

        return Integer.parseInt(new String(chs));
    }
}
