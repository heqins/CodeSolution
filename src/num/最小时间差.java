package num;

public class 最小时间差 {

    /**
     * 题目：给定一组范围在00：00至23：59的时间，求任意两个时
     * 间之间的最小时间差。例如，输入时间数组["23：50"，"23：
     * 59"，"00：00"]，"23：59"和"00：00"之间只有1分钟的间隔，是最
     * 小的时间差。
     * @param args
     */
    public static void main(String[] args) {
        String[] timeArray = new String[]{"23:50", "23:59", "00:00"};
        int solve = solve(timeArray);
        System.out.println(solve);
    }

    public static int solve(String[] timeArray) {
        if (timeArray.length > 1440) {
            return 0;
        }

        boolean[] timeFlags = new boolean[1440];
        for (String time: timeArray) {
            String[] split = time.split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (timeFlags[minutes]) {
                return 0;
            }

            timeFlags[minutes] = true;
        }

        return helper(timeFlags);
    }

    /**
     * first和last的用处：在时间数组中，由于时间是循环的（即在23:59后会跳到00:00），因此要考虑首尾时间之间的时间间隔。
     * 假设时间数组是连续的，并且最后一个时间和第一个时间之间有N分钟的差距，
     * 那么首尾时间之间的最小时间间隔就是1440 - N（一天的总分钟数减去首尾时间的间隔）
     * @param timeFlags
     * @return
     */
    public static int helper(boolean[] timeFlags) {
        int minDiff = timeFlags.length - 1;
        int prev = -1;
        int first = timeFlags.length - 1;
        int last = -1;

        for (int i = 0; i < timeFlags.length; i++) {
            if (timeFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(minDiff, i - prev);
                }

                prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }

        minDiff = Math.min(first + timeFlags.length - last, minDiff);
        return minDiff;
    }
}
